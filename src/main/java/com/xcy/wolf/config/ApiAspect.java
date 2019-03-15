package com.xcy.wolf.config;

import com.xcy.wolf.service.BaseService;
import com.xcy.wolf.service.RequestLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author xcy
 * @date 2019/02/27 16:46
 * @description 切面类
 * @since V1.0.0
 */
@Aspect
@Component
@Slf4j
public class ApiAspect {

    @Autowired
    private RequestLogService requestLogService;


    /**
     * 排除webSocket,被切就报错.
     */
    @Pointcut("execution(public * com.xcy.wolf.controller.*.*(..)) && !execution(public * com.xcy.wolf.controller.MySocket.*(..))")
    public void saveLogAdvice() {
    }

    /**
     * 环绕增强
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("saveLogAdvice()")
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
        //Object result = null;
        String name = pjp.getSignature().getName();
        log.info("请求的方法名:{}", name);
        return requestLogService.saveLog(pjp);

        //Object[] args = pjp.getArgs();
        //if(args != null && args.length >0) {
        //    String deviceId = (String) args[0];
        //    if(!"03".equals(deviceId)) {
        //        return "no anthorization";
        //    }
        //}
        //
        //result =pjp.proceed();
        //return result;
    }

    //@Before("saveLogAdvice()")
    public void beforeAction() throws Throwable {
        log.info("请求的方法名:{}", "beforeAction");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        //do something
    }

    //@After("saveLogAdvice()")
    public void afterAction() throws Throwable {
        log.info("请求的方法名:{}", "afterAction");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        //do something
    }











    @Around("execution(public * com.xcy.wolf.controller.*.test*(..))")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        log.info("@Around: 执行目标方法之前...");
        //改变目标方法的参数值
        Object[] args = pjp.getArgs();
        if (null != args && args.length > 0 && args[0].getClass() == String.class) {
            args[0] = "改变后的参数1";
        }
        log.info("改过之后,立马查询参数1的值: {}", pjp.getArgs()[0]);
        //用改变后的参数执行目标方法
        Object returnValue = pjp.proceed(args);
        log.info("@Around: 执行目标方法之后...");
        log.info("@Around: 被织入的目标对象:{}", pjp.getTarget());
        return "原值返回: " + returnValue;
    }

    @Before("execution(public * com.xcy.wolf.controller.*.test*(..))")
    public void beforeTestAction(JoinPoint jp) {
        log.info("@Before: 模拟权限检查...");
        String method = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        String params = Arrays.toString(jp.getArgs());
        Object target = jp.getTarget();
        log.info("@Before: 被切的方法名: {}, 方法参数: {}, 目标对象: {}", method, params, target);
    }

    @AfterReturning(pointcut = "execution(public * com.xcy.wolf.controller.*.test*(..))", returning = "returnValue")
    public void afterReturningTestAction(JoinPoint jp, Object returnValue) {
        log.info("@AfterReturning: 模拟日志记录的功能...");
        log.info("@AfterReturning: 目标方法为: ", jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());
        log.info("@AfterReturning: 参数为: " + Arrays.toString(jp.getArgs()));
        log.info("@AfterReturning: 返回值为: ", returnValue);
        log.info("@AfterReturning: 被织入的目标对象为: ", jp.getTarget());

    }


    @After("execution(public * com.xcy.wolf.controller.*.test*(..))")
    public void afterTestAction(JoinPoint jp) {
        log.info("@After: 模拟释放资源...");
        String method = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        String params = Arrays.toString(jp.getArgs());
        Object target = jp.getTarget();
        log.info("@After: 被切的方法名: {}, 方法参数: {}, 目标对象: {}", method, params, target);
    }

    /**
     *
     * 没搞懂参数修改,和AfterReturning的作用.头大.
     * http://localhost:8680/AOPTest/testAdvices?param1=111&param2=222
     * @Around: 执行目标方法之前...
     * 改过之后,立马查询参数1的值: 改变后的参数1
     * @Before: 模拟权限检查...
     * @Before: 被切的方法名: com.xcy.wolf.controller.AOPTestController.testAdvices, 方法参数: [111, 222], 目标对象: com.xcy.wolf.controller.AOPTestController@f2c5e32
     * @Around: 执行目标方法之后...
     * @Around: 被织入的目标对象:com.xcy.wolf.controller.AOPTestController@f2c5e32
     * @After: 模拟释放资源...
     * @After: 被切的方法名: com.xcy.wolf.controller.AOPTestController.testAdvices, 方法参数: [111, 222], 目标对象: com.xcy.wolf.controller.AOPTestController@f2c5e32
     * @AfterReturning: 模拟日志记录的功能...
     * @AfterReturning: 目标方法为:
     * @AfterReturning: 参数为: [111, 222]
     * @AfterReturning: 返回值为:
     * @AfterReturning: 被织入的目标对象为:
     *
     */


}

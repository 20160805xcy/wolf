package com.xcy.wolf.config;

import com.xcy.wolf.service.BaseService;
import com.xcy.wolf.service.RequestLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


    @Pointcut("execution(public * com.xcy.wolf.controller.*.*(..))")
    public void saveLogAdvice() {
    }

    @Pointcut("execution(public * com.xcy.wolf.controller.*.test*(..))")
    public void testAop(){

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
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes() ;
        HttpServletRequest request =  sra.getRequest();
        HttpServletResponse response = sra.getResponse();

        //do something
    }

    //@After("saveLogAdvice()")
    public void afterAction() throws Throwable {
        log.info("请求的方法名:{}", "afterAction");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes() ;
        HttpServletRequest request =  sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        //do something
    }


}

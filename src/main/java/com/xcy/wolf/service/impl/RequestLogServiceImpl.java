package com.xcy.wolf.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xcy.wolf.mapper.ApiRequestLogMapper;
import com.xcy.wolf.model.ApiRequestLog;
import com.xcy.wolf.service.BaseService;
import com.xcy.wolf.service.RequestLogService;
import com.xcy.wolf.util.IpUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author xcy
 * @date 2019/02/27 17:27
 * @description 请求日志
 * @since V1.0.0
 */
@Service
public class RequestLogServiceImpl extends BaseService implements RequestLogService {

    @Autowired
    private ApiRequestLogMapper apiRequestLogMapper;

    //使用本地线程类来存各个访问的开始时间.防止污染
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Override
    public Object saveLog(ProceedingJoinPoint pjp) throws Throwable {
        startTime.set(System.currentTimeMillis());
        //获取请求
        HttpServletRequest request = getRequest();
        /**
         * 1. 请求url
         * 2. 请求方法名称
         * 3. 请求参数
         * 4. 请求耗时
         * 5. 请求结果状态
         * 6. 请求者ip
         * 7. 请求者名称
         * 8. 请求方式(get,post)
         * 9. 请求是否是ajax请求
         * 9. 请求sessionId
         * 10. 请求时间
         *
         *  logger.info("获取到的请求url是:{}",request.getRequestURI());
         *  logger.info("获取到的请求方法是:{}",pjp.getSignature().getName());
         *  logger.info("获取到的请求参数是:{}",paramString);
         *  logger.info("获取到的请求ip是:{}", IpUtil.getRealIp(request));
         *  logger.info("获取到的请求者名称是:{}", request.getSession().getAttribute("customerName"));
         *  logger.info("获取到的请求方式为:{}", request.getMethod());
         *  logger.info("获取到的请求方式是否为ajax请求:{}", isAjaxRequest(request));
         *  logger.info("获取到的请求sessionId为:{}", request.getSession().getId());
         *  logger.info("获取到的请求时间为:{}", new Date());
         *  logger.info("获取到的请求结果状态是:{}", response.getStatus());
         *  logger.info("计算到的耗时时间:{}", System.currentTimeMillis() - startTime.get());
         */

        String paramString = JSON.toJSONString(request.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);

        Object result;

        result = pjp.proceed();

        HttpServletResponse response = getResponse();

        ApiRequestLog apiRequestLog = new ApiRequestLog();
        apiRequestLog.setRequestDate(new Date());
        apiRequestLog.setRequestUrl(request.getRequestURI());
        apiRequestLog.setRequestMethod(request.getMethod());
        apiRequestLog.setRequestMethodName(pjp.getSignature().getName());
        apiRequestLog.setRequestParams(paramString);
        apiRequestLog.setIp(IpUtil.getRealIp(request));
        if(null != request.getSession().getAttribute("customerId")){
            apiRequestLog.setCustomerId(Integer.parseInt(request.getSession().getAttribute("customerId").toString()));
        }
        if(null != request.getSession().getAttribute("customerName")){
            apiRequestLog.setCustomerName(request.getSession().getAttribute("customerName").toString());
        }
        apiRequestLog.setAjaxRequestFlag(isAjaxRequest(request));
        apiRequestLog.setRequestSessionId(request.getSession().getId());
        apiRequestLog.setResponseTime(System.currentTimeMillis() - startTime.get());
        apiRequestLog.setStatus(response.getStatus()+"");

        //调用dao层,将数据持久化到数据库
        apiRequestLogMapper.insert(apiRequestLog);

        //用完就删
        startTime.remove();

        return result;
    }

    /**
     * 是否是ajax请求
     * @param request
     * @return
     */
    Boolean isAjaxRequest(HttpServletRequest request){

        String requestType = request.getHeader("X-Requested-With");
        if(null == requestType) return false;
        else return true;

    }
}

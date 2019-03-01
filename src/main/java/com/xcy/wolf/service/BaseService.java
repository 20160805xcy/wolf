package com.xcy.wolf.service;

import com.xcy.wolf.enums.ApiErrorEnum;
import com.xcy.wolf.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.MappedSuperclass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xcy
 * @date 2019/02/27 16:06
 */
@MappedSuperclass
public class BaseService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 抛异常
     */
    protected void throwOpenApiException(ApiErrorEnum error) {
        throw new ApiException(error);
    }

    /**
     * 获取请求
     */
    protected HttpServletRequest getRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        if (request == null) {
            throwOpenApiException(ApiErrorEnum.API_USER_1);
        }
        return request;
    }

    /**
     * 获取响应
     */
    protected HttpServletResponse getResponse() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = sra.getResponse();
        if (response == null) {
            throwOpenApiException(ApiErrorEnum.API_USER_2);
        }
        return response;
    }
}

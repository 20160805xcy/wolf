package com.xcy.wolf.handler;

import com.xcy.wolf.enums.ApiErrorEnum;
import com.xcy.wolf.exception.ApiException;
import com.xcy.wolf.wrapper.BackResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xcy
 * @date 2019/03/11 17:36
 * @description 全局异常拦截
 * @since V1.0.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 默认的异常拦截
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BackResult defaultErrorHandler(Exception e) {
        log.error(e.getMessage(), e);
        return BackResult.failureBack(ApiErrorEnum.CODE_0);
    }

    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public BackResult myErrorHandler(ApiException e) {
        log.error(e.getMessage(), e);
        return BackResult.failureBack(e.getMessage());
    }
}

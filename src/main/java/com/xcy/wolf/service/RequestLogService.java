package com.xcy.wolf.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author xcy
 * @date 2019/02/27 17:26
 * @description 请求日志
 * @since V1.0.0
 */
public interface RequestLogService {

    /**
     * 保存每次接口请求日志
     * @param pjp 连接点pjp
     */
    Object saveLog(ProceedingJoinPoint pjp) throws Throwable;


}

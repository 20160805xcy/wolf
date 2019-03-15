package com.xcy.wolf.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author xcy
 * @date 2019/03/05 11:37
 * @description 在线用户统计监听器
 * @since V1.0.0
 */
@Slf4j
@WebListener
public class OnlineCountListener implements HttpSessionListener {
    //记录session数量
    public int count;

    /**
     * 监听session的创建,synchronized防止并发bug
     * @param se
     */
    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {
        count++;
        log.info("【HttpSessionListener监听器】count++, 值为: " + count);
        se.getSession().getServletContext().setAttribute("count", count);
    }

    /**
     * 监听session的销毁
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Object customerName = se.getSession().getAttribute("customerName");
        count--;
        log.info("(【HttpSessionListener监听器】count--, 剩余在线用户数: {}, 用户名为: {} ", count, customerName.toString());
        se.getSession().getServletContext().setAttribute("count", count);
    }
}

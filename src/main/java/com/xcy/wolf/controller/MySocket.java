package com.xcy.wolf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xcy
 * @date 2019/03/05 17:27
 * @description
 * @since V1.0.0
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class MySocket {

    /**
     * 线程安全的socket集合
     */
    private static CopyOnWriteArraySet<MySocket> webSocketSet = new CopyOnWriteArraySet<>();
    /**
     * 会话
     */
    private Session session;

    /**
     * 当前在线用户数量
     */
    public final AtomicInteger CURRENT_ONLINE_USER_NUMBER = new AtomicInteger(0);

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        log.info("有链接加入，当前人数为: {}", getOnline_num());
        //this.session.getAsyncRemote().sendText("有链接加入，当前人数为:" + getOnline_num());

        if(getOnline_num() >= 1){
            for (MySocket item : webSocketSet) {
                item.session.getAsyncRemote().sendText("现在呢,正有"+CURRENT_ONLINE_USER_NUMBER.get()+"用户跟你一起在线");
            }
        }

    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        this.session.getAsyncRemote().sendText(getOnline_num()+"  gg");
        log.info("有链接关闭,当前人数为: {}",getOnline_num());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("来自客户端的消息: {}", message);
        for (MySocket item : webSocketSet) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public synchronized int getOnline_num() {
        return CURRENT_ONLINE_USER_NUMBER.get();
    }

    public synchronized int subOnlineCount() {
        return CURRENT_ONLINE_USER_NUMBER.getAndDecrement();
    }

    public synchronized int addOnlineCount() {
        return CURRENT_ONLINE_USER_NUMBER.getAndIncrement();
    }
}

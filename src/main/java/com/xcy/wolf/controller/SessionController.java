package com.xcy.wolf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

/**
 * @author xcy
 * @date 2019/03/05 11:47
 * @description 模拟
 * @since V1.0.0
 */
@Controller
@RequestMapping("session")
public class SessionController {

    @ResponseBody
    @RequestMapping("getOnlineCount")
    public String count(HttpServletRequest request, HttpServletResponse response) {
        //把sessionId记录在浏览器
        try {
            Cookie c = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "utf-8"));
            c.setPath("/");
            //先设置cookie有效期为2天,不用担心,session不会保存2天
            c.setMaxAge(48 * 60 * 60);
            response.addCookie(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //作用: 该用户如果没有session则创建session,有则取得session不创建
        HttpSession session = request.getSession();
        Object count = session.getServletContext().getAttribute("count");
        return "count: " + count;

    }
}

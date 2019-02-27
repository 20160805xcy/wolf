package com.xcy.wolf.filter;

import com.xcy.wolf.common.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author xcy
 * @date 2019/02/18 17:44
 * @description 权限过滤
 * @since V1.0.0
 */
@Slf4j
@Component
public class AuthorityFilter extends HttpServlet implements Filter {

    private static final long serialVersionUID = -4275105240038370264L;

    @Override
    public void init(FilterConfig arg0) {
        log.info("服务启动,调用过滤器Filter初始化方法init()..........");
    }

    @Override
    public void destroy() {
        log.info("服务关闭，调用过滤器Filter的销毁方法destroy()..........");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("服务启动，调用过滤器Filter的过滤方法 doFilter()..........");
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpSession session = servletRequest.getSession();
        //获取项目根路径
        String accessPath = servletRequest.getContextPath();
        // 获取当前访问路径
        String url = servletRequest.getRequestURI();
        //记录用户操作
        log.info("访问客户ip:{},访问时间:{},访问url:{})", getRealIp(servletRequest), DateUtils.parse2LongString(new Date()), url);
        url = url.substring(url.lastIndexOf("/") + 1);
        log.info("访问的url为:{}", url);

        Boolean isExclude = false;
        // 不需要过滤的请求
        String[] excludeUrlArr = {"logIn", "toLogIn", "favicon.ico"};
        for (String excludeUrl : excludeUrlArr) {
            if (url.equals(excludeUrl)) {
                isExclude = true;
            }
        }

        // 需要过滤的请求,如果session为空则强制用户进行登录.
        if (!isExclude) {
            String customerName = (String) session.getAttribute("customerName");
            if (null != customerName) {
                filterChain.doFilter(request, response);
            } else {
                log.info("强制跳转到登录页啊啊啊啊啊------>login.jsp");
                existLogin(response);
            }
        } else {
            log.info("正常访问登录页----->login.jsp");
            filterChain.doFilter(request, response);
        }
    }


    /**
     * 定向到登录页
     * @param response
     * @throws IOException
     */
    private void existLogin(ServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println("<html>");
            out.println("<script type=\"text/javascript\">");
            out.println("window.location.href='/customer/toLogIn'");
            out.println("</script>");
            out.println("</html>");
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 获取操作用户ip
     * @param request
     * @return
     */
    private String getRealIp(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：webLogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


}

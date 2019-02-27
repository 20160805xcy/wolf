package com.xcy.wolf.config;

import com.xcy.wolf.filter.AuthorityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xcy
 * @date 2019/02/26 14:02
 * @description
 * @since V1.0.0
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean AuthorityFilter() {
        //创建 过滤器注册bean
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        AuthorityFilter authorityFilter = new AuthorityFilter();

        registrationBean.setFilter(authorityFilter);

        List urls = new ArrayList();
        //给所有请求加过滤器
        urls.add("/*");
        //设置 有效url
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }
}

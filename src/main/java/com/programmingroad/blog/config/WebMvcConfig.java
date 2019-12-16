package com.programmingroad.blog.config;

import com.programmingroad.blog.interceptor.RestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: baoqi.liu
 * @create: 2019/12/16 14:18
 * @description:
 * @version: 1.0
 **/

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private RestInterceptor restInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restInterceptor).addPathPatterns("/api/admin/**");
    }
}

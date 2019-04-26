package org.luo.mybatisplus.config;

import org.luo.mybatisplus.interceptor.AjaxDomainInterceptor;
import org.luo.mybatisplus.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Resource
    private AjaxDomainInterceptor ajaxDomainInterceptor;

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(ajaxDomainInterceptor).addPathPatterns("/**");

        // 登陆拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/**");

    }
}

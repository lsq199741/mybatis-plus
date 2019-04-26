package org.luo.mybatisplus.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AjaxDomainInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response, Object handler)
            throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置允许哪些域名应用进行ajax访问
        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        return true;
    }
}

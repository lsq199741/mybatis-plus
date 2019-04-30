//package org.luo.mybatisplus.filter;
//
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(servletNames={"dispatcherServlet"})
//public class AjaxDomainFilter implements Filter{
//
//    @Override
//    public void destroy() {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletResponse httpResponse = (HttpServletResponse)response;
//        httpResponse.setHeader("Access-Control-Allow-Origin", "*");//设置允许哪些域名应用进行ajax访问
//        httpResponse.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
//        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type");
//        chain.doFilter(request, response);//调用后续serlvet
//    }
//
//    @Override
//    public void init(FilterConfig arg0) throws ServletException {
//        // TODO Auto-generated method stub
//    }
//}

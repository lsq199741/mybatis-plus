package org.luo.mybatisplus.interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/** 
 * 登录认证的拦截器 
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * Handler执行完成之后调用这个方法
	 */
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exc)
			throws Exception {

	}

	/**
	 * Handler执行之后，ModelAndView返回之前调用这个方法
	 */
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
	}

	/**
	 * Handler执行之前调用这个方法
	 */
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		
		// 获取请求的URL
		String url = request.getRequestURI();
		
		// 获取Session
		HttpSession session = request.getSession();
		
		// session attribute obj
		Object obj = null;
		if (url.indexOf("front") >= 0) {
//			Map<String, Object> userinfoMap = new HashMap();
//			userinfoMap.put("user_id", 1);
//			session.setAttribute("backuser", userinfoMap);
			obj = session.getAttribute("frontuser");
		} else if (url.indexOf("back") >= 0) {
//			Map<String, Object> userinfoMap = new HashMap();
//			userinfoMap.put("admin_id", 1);
//			session.setAttribute("adminuser", userinfoMap);
			obj = session.getAttribute("backuser");
		} else {
			return true;
		}
		
		if (obj == null) {
			System.out.println("LoginInterceptor:: user_id:obj is null");
			
			Map<String, Object> rMap = new HashMap();
			rMap.put("r", 0);
			
			//Map<String, Object> fieldMap = new HashMap();
			//fieldMap.put("login", "请登录！");
			
			rMap.put("msg", "请登录！");
			
	    	response.setCharacterEncoding("UTF-8");
	    	response.getWriter().write(JSON.toJSONString(rMap));
	    	response.getWriter().flush();
	    	response.getWriter().close();
			return false;
		} else {
			Map map = (Map)obj;
			System.out.println("LoginInterceptor:: user_id:" + map.get("user_id"));
		}

		return true;
	}

}

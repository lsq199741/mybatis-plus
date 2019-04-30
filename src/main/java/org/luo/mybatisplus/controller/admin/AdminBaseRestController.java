package org.luo.mybatisplus.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.luo.mybatisplus.utils.WebUtilsPro;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class AdminBaseRestController {


    /**
     * 登录认证异常
     */
    @ExceptionHandler({UnauthenticatedException.class, AuthenticationException.class})
    public String authenticationException(HttpServletRequest request, HttpServletResponse response) {
//        if (WebUtilsPro.isAjaxRequest(request)) {
        // 输出JSON
        Map<String, Object> map = new HashMap<>();
        map.put("r", "0");
        map.put("msg", "未登录");
        writeJson(map, response);
        return null;
//        } else {
//            return "redirect:/system/login";
//        }
    }

    /**
     * 权限异常
     */
    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
    @ResponseBody
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
//        if (WebUtilsPro.isAjaxRequest(request)) {
        // 输出JSON
        Map<String, Object> map = new HashMap<>();
        map.put("r", "0");
        map.put("msg", "无权限");
        writeJson(map, response);
        return null;
//        } else {
//            return "redirect:/system/403";
//        }
    }

    /**
     * 输出JSON
     *
     * @param response
     * @author SHANHY
     * @create 2017年4月4日
     */
    private void writeJson(Map<String, Object> map, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            out.write(new JSONObject(map).toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /*
     * @Author shuqiang
     * @Desc
     * @Date 2019-04-30 17:20
     */
    public Map<String, Object> success(Object o) {
        Map<String, Object> rMap = new HashMap<>();

        rMap.put("r", 1);
        rMap.put("data", o);
        rMap.put("count", 1);

        return rMap;
    }

    /*
     * @Author shuqiang
     * @Desc
     * @Date 2019-04-30 17:20
     */
    public Map<String, Object> success(Object data, Integer count) {
        Map<String, Object> rMap = new HashMap<>();

        rMap.put("r", 1);
        rMap.put("data", data);
        rMap.put("count", count);

        return rMap;
    }

    /*
     * @Author shuqiang
     * @Desc
     * @Date 2019-04-30 17:20
     */
    public Map<String, Object> error(String msg) {
        Map<String, Object> rMap = new HashMap<>();

        rMap.put("r", 0);
        rMap.put("msg", msg);

        return rMap;
    }

}

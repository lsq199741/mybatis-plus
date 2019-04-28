package org.luo.mybatisplus.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.luo.mybatisplus.model.entity.User;
import org.luo.mybatisplus.model.param.LoginParam;
import org.luo.mybatisplus.service.IUserService;
import org.luo.mybatisplus.utils.MD5Utils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Api(value = "/admin", tags = "管理员登陆模块")
@Slf4j
@Validated
@RestController
@RequestMapping("/admin")
public class LoginRestController {

    @Resource
    private IUserService userService;

    @ApiOperation("登陆")
    @PostMapping(value = "/login")
    public Map login(@RequestBody @Validated LoginParam loginParam) {
        Map<String, Object> rMap = new HashMap<>();
        rMap.put("r", 1);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginParam.getAccount(), loginParam.getPassword());

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            rMap.put("r",0);
            return rMap;
        }




//        QueryWrapper wrapper = new QueryWrapper<>();
//        wrapper.eq("account", loginParam.getAccount());
//        wrapper.eq("password", MD5Utils.getMd5(loginParam.getPassword()));
//        User user = userService.getOne(wrapper);
//        if (user != null) {
//            rMap.put("user", user);
//        } else {
//            rMap.put("r", 0);
//            rMap.put("user", null);
//        }
        return rMap;
    }


}

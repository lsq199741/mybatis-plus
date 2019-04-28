package org.luo.mybatisplus.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.luo.mybatisplus.model.entity.User;
import org.luo.mybatisplus.model.param.LoginParam;
import org.luo.mybatisplus.service.IUserService;
import org.luo.mybatisplus.utils.MD5Utils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Api(value="/admin", tags="登陆模块")
@Slf4j
@Validated
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private IUserService userService;

    @ApiOperation("登陆")
    @PostMapping(value = "/login")
    public Map login(@RequestBody @Validated LoginParam loginParam) {
        Map<String, Object> rMap = new HashMap<>();
        rMap.put("r", 1);

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("account", loginParam.getAccount());
        wrapper.eq("password", MD5Utils.getMd5(loginParam.getPassword()));
        User user = userService.getOne(wrapper);
        if (user != null) {
            rMap.put("user",user);
        }else {
            rMap.put("r",0);
            rMap.put("user",null);
        }

        return rMap;
    }


}

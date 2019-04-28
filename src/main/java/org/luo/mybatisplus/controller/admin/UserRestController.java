package org.luo.mybatisplus.controller.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.luo.mybatisplus.model.dto.LoginDTO;
import org.luo.mybatisplus.model.entity.User;
import org.luo.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-26
 */
@Api(value = "/user", tags = "管理员后台用户管理模块")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @ApiOperation("查询单个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",paramType = "query")
    })
    @GetMapping("/get")
    public Map get(@RequestParam(value = "id", required = false) Integer id) {
        Map rMap = new HashMap();
        User user = userService.getById(id);
        rMap.put("user", user.convert(LoginDTO.class));
        return rMap;
    }
}

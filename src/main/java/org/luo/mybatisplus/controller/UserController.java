package org.luo.mybatisplus.controller;


import lombok.extern.slf4j.Slf4j;
import org.luo.mybatisplus.entity.User;
import org.luo.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/get")
    public Map get(@Valid Integer id){
        Map rMap = new HashMap();

        log.info("#########  info  #########");
        log.debug("#########  debug  #########");
        log.error("#########  error  #########");

        User user = userService.getById(id);
        rMap.put("user",user);

        return rMap;
    }


}

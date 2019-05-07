package org.luo.mybatisplus.controller.admin;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.luo.mybatisplus.service.AdminRoleService;
import org.luo.mybatisplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/adminLogin", tags = "管理员角色管理模块")
@Slf4j
@Validated
@RestController
@RequestMapping("/adminRole")
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private AdminRoleService adminRoleService;


}

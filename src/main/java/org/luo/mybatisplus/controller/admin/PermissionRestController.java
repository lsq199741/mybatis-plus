package org.luo.mybatisplus.controller.admin;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.luo.mybatisplus.service.PermissionService;
import org.luo.mybatisplus.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "/adminLogin", tags = "管理员许可管理模块")
@Slf4j
@Validated
@RestController
@RequestMapping("/adminPermission")
public class PermissionRestController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionService rolePermissionService;


}

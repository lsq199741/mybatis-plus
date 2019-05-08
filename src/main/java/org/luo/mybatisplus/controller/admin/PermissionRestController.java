package org.luo.mybatisplus.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.luo.mybatisplus.controller.AdminBaseRestController;
import org.luo.mybatisplus.model.entity.Permission;
import org.luo.mybatisplus.model.param.PermissionAddParam;
import org.luo.mybatisplus.service.PermissionService;
import org.luo.mybatisplus.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Api(value = "/adminLogin", tags = "管理员许可管理模块")
@Slf4j
@Validated
@RequiresUser
@RestController
@RequestMapping("/adminPermission")
public class PermissionRestController extends AdminBaseRestController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionService rolePermissionService;


    @ApiOperation("获取许可列表")
    @RequiresRoles("sys_admin")
    @GetMapping("/permissionList")
    public Map permissionList(@RequestParam String name) {

        QueryWrapper wrapper = new QueryWrapper();
        if (!name.equals("all"))
            wrapper.like("name", name);

        List<Permission> data = permissionService.list(wrapper);
        Integer count = permissionService.count(wrapper);

        return success(data, count);
    }

    @ApiOperation("许可新增")
    @RequiresRoles("sys_admin")
    @PostMapping("/permissionAdd")
    public Map permissionAdd(@RequestBody @Validated PermissionAddParam permissionAddParam) {
        QueryWrapper wrapper = new QueryWrapper();
        String permission = permissionAddParam.getPermission();

        wrapper.eq("permission", permission);

        Permission exists = permissionService.getOne(wrapper);

        if (exists == null) {
            boolean r = permissionService.save(permissionAddParam.convert(Permission.class));
            if (!r)
                return error("新增失败，请重试");
            else
                return success();

        } else {
            return error("该许可名已存在");
        }

    }
}

package org.luo.mybatisplus.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.luo.mybatisplus.controller.AdminBaseRestController;
import org.luo.mybatisplus.model.entity.Role;
import org.luo.mybatisplus.model.param.RoleAddParam;
import org.luo.mybatisplus.model.param.RoleUpdateParam;
import org.luo.mybatisplus.service.AdminRoleService;
import org.luo.mybatisplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "/adminLogin", tags = "管理员角色管理模块")
@Slf4j
@Validated
@RequiresUser
@RestController
@RequestMapping("/adminRole")
public class RoleRestController extends AdminBaseRestController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private AdminRoleService adminRoleService;


    @ApiOperation("管理员角色列表")
    @RequiresRoles("sys_admin")
    @GetMapping("roleList")
    public Map roleList(@RequestParam String title) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (!title.equals("all"))
            queryWrapper.like("title", title);

        List<Role> data = null;
        Integer count = null;
        try {
            data = roleService.list(queryWrapper);
            count = roleService.count(queryWrapper);
        } catch (Exception e) {
            return error("获取角色列表失败，请重试");
        }

        return success(data, count);
    }

    @ApiOperation("管理员角色详情")
    @RequiresRoles("sys_admin")
    @GetMapping("/roleInfo/{id}")
    public Map roleInfo(@PathVariable Integer id) {
        Role data = roleService.getById(id);
        if (data == null) return error("该角色不存在！");
        return success(data);
    }

    @ApiOperation("管理员角色添加")
    @RequiresRoles("sys_admin")
    @PostMapping("/roleAdd")
    public Map roleAdd(@RequestBody @Validated RoleAddParam roleAddParam) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", roleAddParam.getName());

        Role exists = roleService.getOne(wrapper);
        if (exists == null) {
            boolean r = roleService.save(roleAddParam.convert(Role.class));
            if (!r)
                return error("新增失败，请重试");
        } else
            return error("该角色已存在");

        return success();
    }


    @ApiOperation("管理员角色修改")
    @RequiresRoles("sys_admin")
    @PostMapping("/roleUpdate")
    public Map roleUpdate(@RequestBody @Validated RoleUpdateParam roleUpdateParam) {
        Role exists = roleService.getById(roleUpdateParam.getId());
        if (exists != null) {
            boolean r = roleService.updateById(roleUpdateParam.convert(Role.class));
            if (!r) return error("修改失败，请重试");
        } else {
            return error("该角色不存在！");
        }
        return success();
    }

    @ApiOperation("管理员角色删除")
    @RequiresRoles("sys_admin")
    @PostMapping("/roleDelete")
    public Map roleDelete(@RequestParam Integer id) {
        Role exists = roleService.getById(id);
        if (exists != null) {
            boolean r = roleService.removeById(id);
            if (!r) return error("角色删除失败，请重试");
        } else {
            return error("该角色不存在！");
        }
        return success();
    }
}

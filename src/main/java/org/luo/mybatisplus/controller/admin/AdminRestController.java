package org.luo.mybatisplus.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.luo.mybatisplus.model.entity.Admin;
import org.luo.mybatisplus.service.AdminRoleService;
import org.luo.mybatisplus.service.AdminService;
import org.luo.mybatisplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "/admin", tags = "管理员用户管理模块")
@Slf4j
@Validated
@RestController
@RequestMapping("/admin")
public class AdminRestController extends AdminBaseRestController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private RoleService roleService;


    @RequiresUser
    @RequiresPermissions("systemUserList")
    @ApiOperation("管理员列表")
    @GetMapping(value = "/adminList")
    public Map adminList(@Valid String nickName) {
        Subject author = SecurityUtils.getSubject();
        Admin admin = (Admin) author.getPrincipal();
        if (admin != null) {
            QueryWrapper wrapper = new QueryWrapper();
            if (!nickName.equals("all")) {
                wrapper.like("nickName", nickName);
            }
            wrapper.notIn("id", admin.getId());

            List<Admin> data = adminService.list(wrapper);
            Integer count = adminService.count(wrapper);

            return success(data,count);
        } else {
            return error("登陆异常");
        }
    }


}

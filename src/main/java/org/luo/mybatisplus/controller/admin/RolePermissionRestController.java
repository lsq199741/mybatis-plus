package org.luo.mybatisplus.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.luo.mybatisplus.controller.AdminBaseRestController;
import org.luo.mybatisplus.model.dto.StairMenuDTO;
import org.luo.mybatisplus.model.entity.Permission;
import org.luo.mybatisplus.model.entity.Role;
import org.luo.mybatisplus.model.entity.RolePermission;
import org.luo.mybatisplus.service.PermissionService;
import org.luo.mybatisplus.service.RolePermissionService;
import org.luo.mybatisplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(value = "/adminRolePermission", tags = "管理员角色许可管理模块")
@Slf4j
@Validated
@RequiresUser
@RestController
@RequestMapping("/adminRolePermission")
public class RolePermissionRestController extends AdminBaseRestController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @ApiOperation("管理员角色菜单许可详情")
    @RequiresRoles("sys_admin")
    @GetMapping("/rolePermissionMenuInfo/{roleId}")
    public Map rolePermissionInfo(@PathVariable Integer roleId) {
        Role role = roleService.getById(roleId);

        if (role != null) {
            List<Integer> permissions = rolePermissionService.selectPermissionByRoleId(roleId);
            if (permissions.size() > 0) {
                List<StairMenuDTO> data = permissionService.selectPermissionByRoleId(roleId);
                return success(data);
            } else
                return error("该角色没有任何许可");
        } else
            return error("该角色不存在");
    }


}

package org.luo.mybatisplus.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.luo.mybatisplus.controller.AdminBaseRestController;
import org.luo.mybatisplus.model.dto.AdminInfoDTO;
import org.luo.mybatisplus.model.entity.Admin;
import org.luo.mybatisplus.model.entity.Role;
import org.luo.mybatisplus.model.param.AdminAddParam;
import org.luo.mybatisplus.service.AdminRoleService;
import org.luo.mybatisplus.service.AdminService;
import org.luo.mybatisplus.service.RoleService;
import org.luo.mybatisplus.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    /*
     * @Author shuqiang
     * @Desc 管理员列表
     * @Date 2019-04-30 22:14
     */
    @RequiresUser
    @RequiresRoles("sys_admin")
    @RequiresPermissions("adminList")
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

            return success(data, count);
        } else {
            return error("登陆异常");
        }
    }

    /*
     * @Author shuqiang
     * @Desc 管理员详情
     * @Date 2019-04-30 22:14
     */
    @ApiOperation("管理员详情")
    @RequiresUser
    @RequiresPermissions("adminInfo")
    @GetMapping("/adminInfo/{adminId}")
    public Map adminInfo(@PathVariable Integer adminId) {
        Map<String, Object> data = new HashMap<>();

        Admin admin = adminService.getById(adminId);
        if (admin != null) {
            AdminInfoDTO adminInfo = admin.convert(AdminInfoDTO.class);
            if (adminInfo.getCreateAdmin() != null) {
                Admin cadmin = adminService.getById(adminInfo.getCreateAdmin());
                if (cadmin != null) {
                    adminInfo.setCreateAdminNickName(cadmin.getNickname());
                }
            }
            data.put("admin", adminInfo);
            return success(data);
        } else {
            return error("管理员不存在");
        }
    }

    /*
     * @Author shuqiang
     * @Desc 管理员添加
     * @Date 2019-04-30 22:15
     */
    @ApiOperation("管理员添加")
    @RequiresUser
    @RequiresPermissions("adminAdd")
    @PostMapping("/adminAdd")
    public Map adminAdd(@RequestBody @Validated AdminAddParam adminAddParam) {
        //判断用户名是否存在
        Admin isRepeat = adminService.findByUserName(adminAddParam.getUsername());
        if (isRepeat == null) {
            Subject subject = SecurityUtils.getSubject();
            Admin cadmin = (Admin) subject.getPrincipal();

            Admin admin = new Admin();
            admin.setNickname(adminAddParam.getNickname());
            admin.setUsername(adminAddParam.getUsername());
            admin.setSalt(adminAddParam.getSalt());
            //设置密码，初试密码为 123456
            String password = MD5Utils.getPassword("123456", adminAddParam.getSalt());
            admin.setPassword(password);
            admin.setCreateAdmin(cadmin.getId());

            boolean r = adminService.save(admin);
            if (r) {
                return success();
            } else {
                return error("添加失败，请重试");
            }
        } else {
            return error("用户名已存在！");
        }
    }


    /*
     * @Author shuqiang
     * @Desc 角色列表
     * @Date 2019-04-30 22:15
     */

    /*
     * @Author shuqiang
     * @Desc 管理员修改
     * @Date 2019-04-30 22:15
     */

    /*
     * @Author shuqiang
     * @Desc 管理员删除
     * @Date 2019-04-30 22:16
     */


    /*
     * @Author shuqiang
     * @Desc 修改密码
     * @Date 2019-04-30 22:16
     */


    /*
     * @Author shuqiang
     * @Desc 重置密码
     * @Date 2019-04-30 22:16
     */


}

package org.luo.mybatisplus.controller.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.luo.mybatisplus.controller.AdminBaseRestController;
import org.luo.mybatisplus.model.dto.LoginDTO;
import org.luo.mybatisplus.model.entity.Admin;
import org.luo.mybatisplus.model.param.AdminUpdatePasswordParam;
import org.luo.mybatisplus.model.param.LoginParam;
import org.luo.mybatisplus.service.AdminService;
import org.luo.mybatisplus.service.IUserService;
import org.luo.mybatisplus.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Api(value = "/adminLogin", tags = "管理员登陆模块")
@Slf4j
@Validated
@RestController
@RequestMapping("/adminLogin")
public class LoginRestController extends AdminBaseRestController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("登陆")
    @PostMapping(value = "/login")
    public Map login(@RequestBody @Validated LoginParam loginParam) {
        Map<String, Object> rMap = new HashMap<>();
        rMap.put("r", 1);


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginParam.getAccount(), loginParam.getPassword(), true);
        try {
            //shiro帮我们匹配密码什么的，我们只需要把东西传给它，它会根据我们在UserRealm里认证方法设置的来验证
            subject.login(token);

            Session session = subject.getSession();
            session.setAttribute("admin", subject.getPrincipal());
            Admin admin = (Admin) subject.getPrincipal();
            rMap.put("admin", admin.convert(LoginDTO.class));
        } catch (UnknownAccountException e) {
            //账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
            rMap.put("r", 0);
            rMap.put("msg", "账号不存在！");
        } catch (DisabledAccountException e) {
            rMap.put("r", 0);
            rMap.put("msg", "账号未启用！");
        } catch (IncorrectCredentialsException e) {
            rMap.put("r", 0);
            rMap.put("msg", "密码错误");
        } catch (Throwable e) {
            rMap.put("r", 0);
            rMap.put("msg", "未知错误！");
        }
        return rMap;
    }

    @RequiresUser
    @ApiOperation("登出")
    @PostMapping(value = "/logout")
    public Map logout() {
        Map<String, Object> rMap = new HashMap<>();
        rMap.put("r", 1);

        Subject admin = SecurityUtils.getSubject();

        Session session = admin.getSession();

        Admin admin1 = (Admin) session.getAttribute("admin");

        admin.logout();

        return rMap;
    }


    @RequiresUser
    @ApiOperation("修改密码")
    @PostMapping(value = "/updatePassword")
    public Map updatePassword(@RequestBody @Validated AdminUpdatePasswordParam adminUpdatePasswordParam) {
        Map<String, Object> rMap = new HashMap<>();
        rMap.put("r", 1);
        Subject subject = SecurityUtils.getSubject();

        Admin admin = (Admin) subject.getPrincipal();

        String oldPassword = MD5Utils.getPassword(adminUpdatePasswordParam.getOldPassword(), admin.getSalt());
        String newPassword = MD5Utils.getPassword(adminUpdatePasswordParam.getNewPassword(), admin.getSalt());

        if (oldPassword.equals(admin.getPassword())) {
            if (!oldPassword.equals(newPassword)) {
                admin.setPassword(newPassword);
                boolean r = adminService.updateById(admin);
                if (!r) return error("修改失败，请重试！");
                else return success();
            } else return error("新密码不能与旧密码相同！");
        } else return error("密码有误，请重新输入！");
    }


}

package org.luo.mybatisplus.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.luo.mybatisplus.model.entity.Admin;
import org.luo.mybatisplus.service.AdminService;
import org.luo.mybatisplus.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:07
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("doGetAuthorizationInfo");
        Admin admin = (Admin) principals.getPrimaryPrincipal();
        List<String> sysPermissions = permissionService.selectPermissionByUserId(admin.getId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(sysPermissions);
        log.info("doGetAuthorizationInfo");
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Admin admin = adminService.findByUserName(token.getUsername());
        if (admin == null) {
            return null;
        }
        log.info("doGetAuthenticationInfo");
        return new SimpleAuthenticationInfo(admin, admin.getPassword().toCharArray(), ByteSource.Util.bytes(admin.getSalt()), getName());
    }
}

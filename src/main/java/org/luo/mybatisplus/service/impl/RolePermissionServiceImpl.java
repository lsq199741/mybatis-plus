package org.luo.mybatisplus.service.impl;

import org.luo.mybatisplus.model.entity.RolePermission;
import org.luo.mybatisplus.mapper.RolePermissionMapper;
import org.luo.mybatisplus.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色许可表 服务实现类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

    @Resource
    private RolePermissionMapper rolePermissionMapper;


    @Override
    public List<Integer> selectPermissionByRoleId(Integer roleId) {
        return rolePermissionMapper.selectPermissionByRoleId(roleId);
    }
}

package org.luo.mybatisplus.service.impl;

import org.luo.mybatisplus.model.entity.Permission;
import org.luo.mybatisplus.mapper.PermissionMapper;
import org.luo.mybatisplus.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<String> selectPermissionByUserId(Integer userId) {
        return permissionMapper.selectPermissionByUserId(userId);
    }
}

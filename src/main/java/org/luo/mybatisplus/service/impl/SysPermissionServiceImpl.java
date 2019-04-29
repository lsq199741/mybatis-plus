package org.luo.mybatisplus.service.impl;

import org.luo.mybatisplus.mapper.SysPermissionMapper;
import org.luo.mybatisplus.model.entity.SysPermission;
import org.luo.mybatisplus.service.SysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-29
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<String> selectPermissionByUserId(Long user_id) {
        return sysPermissionMapper.selectPermissionByUserId(user_id);
    }
}

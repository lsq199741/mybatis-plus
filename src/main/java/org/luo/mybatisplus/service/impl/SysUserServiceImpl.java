package org.luo.mybatisplus.service.impl;

import org.luo.mybatisplus.mapper.SysUserMapper;
import org.luo.mybatisplus.model.entity.SysUser;
import org.luo.mybatisplus.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    public SysUser findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}

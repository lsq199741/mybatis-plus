package org.luo.mybatisplus.service.impl;

import org.luo.mybatisplus.mapper.UserMapper;
import org.luo.mybatisplus.model.entity.User;
import org.luo.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}

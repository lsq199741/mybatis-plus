package org.luo.mybatisplus.service.impl;

import org.luo.mybatisplus.model.entity.Admin;
import org.luo.mybatisplus.mapper.AdminMapper;
import org.luo.mybatisplus.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 管理员用户表 服务实现类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin findByUserName(String userName) {
        return adminMapper.findByUserName(userName);
    }
}

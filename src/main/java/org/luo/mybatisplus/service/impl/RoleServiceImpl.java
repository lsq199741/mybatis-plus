package org.luo.mybatisplus.service.impl;

import org.luo.mybatisplus.model.entity.Role;
import org.luo.mybatisplus.mapper.RoleMapper;
import org.luo.mybatisplus.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

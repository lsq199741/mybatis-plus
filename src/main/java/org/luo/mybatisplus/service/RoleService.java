package org.luo.mybatisplus.service;

import org.luo.mybatisplus.model.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
public interface RoleService extends IService<Role> {

    List<String> selectRoleByAdminId(Integer adminId);
}

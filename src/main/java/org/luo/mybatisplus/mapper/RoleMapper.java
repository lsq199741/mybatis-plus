package org.luo.mybatisplus.mapper;

import org.luo.mybatisplus.model.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<String> selectRoleByAdminId(Integer adminId);

}

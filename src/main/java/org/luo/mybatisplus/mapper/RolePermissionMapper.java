package org.luo.mybatisplus.mapper;

import org.luo.mybatisplus.model.entity.Admin;
import org.luo.mybatisplus.model.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色许可表 Mapper 接口
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {


    List<Integer> selectPermissionByRoleId(Integer roleId);
}

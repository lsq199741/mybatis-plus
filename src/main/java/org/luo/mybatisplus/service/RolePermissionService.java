package org.luo.mybatisplus.service;

import org.apache.ibatis.annotations.Param;
import org.luo.mybatisplus.model.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色许可表 服务类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
public interface RolePermissionService extends IService<RolePermission> {

    List<Integer> selectPermissionByRoleId(@Param("roleId") Integer roleId);

}

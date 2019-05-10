package org.luo.mybatisplus.service;

import org.luo.mybatisplus.model.dto.StairMenuDTO;
import org.luo.mybatisplus.model.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
public interface PermissionService extends IService<Permission> {

    List<String> selectPermissionByUserId(Integer userId);

    List<StairMenuDTO> selectAllPermission();

    List<StairMenuDTO> selectPermissionByRoleId(Integer roleId);


}

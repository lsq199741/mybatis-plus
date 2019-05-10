package org.luo.mybatisplus.mapper;

import io.swagger.annotations.Api;
import org.luo.mybatisplus.model.dto.ApiDTO;
import org.luo.mybatisplus.model.dto.SecondaryMenuDTO;
import org.luo.mybatisplus.model.dto.StairMenuDTO;
import org.luo.mybatisplus.model.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<String> selectPermissionByUserId(Integer parentId);

    List<StairMenuDTO> selectStairMenuByRoleId(Integer roleId);

    List<SecondaryMenuDTO> selectSecondaryMenuByStairId(Integer parentId, Integer roleId);

    List<ApiDTO> selectApiBySecondaryMenuId(Integer parentId, Integer roleId);
}

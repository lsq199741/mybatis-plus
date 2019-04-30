package org.luo.mybatisplus.mapper;

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

}

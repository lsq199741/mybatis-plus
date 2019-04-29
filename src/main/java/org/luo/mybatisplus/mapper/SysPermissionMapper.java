package org.luo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.luo.mybatisplus.model.entity.SysPermission;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-29
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<String> selectPermissionByUserId(@Param("parentId") Long parentId);

}

package org.luo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.luo.mybatisplus.model.entity.SysUser;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-29
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByUserName(String userName);

}

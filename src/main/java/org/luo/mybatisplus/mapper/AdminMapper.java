package org.luo.mybatisplus.mapper;

import org.luo.mybatisplus.model.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 管理员用户表 Mapper 接口
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Admin findByUserName(String userName);

}

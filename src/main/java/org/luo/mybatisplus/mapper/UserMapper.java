package org.luo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.luo.mybatisplus.model.entity.User;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-26
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User findUserByUsername(@Param("username") String username);

}

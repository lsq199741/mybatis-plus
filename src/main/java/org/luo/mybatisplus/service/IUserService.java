package org.luo.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.luo.mybatisplus.model.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-26
 */
public interface IUserService extends IService<User> {

    User findUserByUsername(String username);

}

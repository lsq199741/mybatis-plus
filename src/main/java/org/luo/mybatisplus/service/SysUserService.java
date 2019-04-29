package org.luo.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.luo.mybatisplus.model.entity.SysUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-29
 */
public interface SysUserService extends IService<SysUser> {
    SysUser findByUserName(String userName);
}

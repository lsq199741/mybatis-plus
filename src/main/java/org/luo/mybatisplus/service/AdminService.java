package org.luo.mybatisplus.service;

import org.apache.ibatis.annotations.Param;
import org.luo.mybatisplus.model.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员用户表 服务类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
public interface AdminService extends IService<Admin> {
    Admin findByUserName(@Param("userName") String userName);
}

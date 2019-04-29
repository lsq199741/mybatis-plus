package org.luo.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.luo.mybatisplus.model.entity.SysPermission;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-29
 */
public interface SysPermissionService extends IService<SysPermission> {

    List<String> selectPermissionByUserId(Long user_id);

}

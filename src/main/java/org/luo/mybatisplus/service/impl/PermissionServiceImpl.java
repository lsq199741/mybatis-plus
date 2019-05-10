package org.luo.mybatisplus.service.impl;

import org.luo.mybatisplus.model.dto.ApiDTO;
import org.luo.mybatisplus.model.dto.SecondaryMenuDTO;
import org.luo.mybatisplus.model.dto.StairMenuDTO;
import org.luo.mybatisplus.model.entity.Permission;
import org.luo.mybatisplus.mapper.PermissionMapper;
import org.luo.mybatisplus.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shuqiang
 * @since 2019-04-30
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<String> selectPermissionByUserId(Integer userId) {
        return permissionMapper.selectPermissionByUserId(userId);
    }

    @Override
    public List<StairMenuDTO> selectAllPermission() {
        return null;
    }

    @Override
    public List<StairMenuDTO> selectPermissionByRoleId(Integer roleId) {
        List<StairMenuDTO> stairMenus = permissionMapper.selectStairMenuByRoleId(roleId);
        if (stairMenus.size() > 0) {
            for (StairMenuDTO stair : stairMenus) {
                Integer parentId = stair.getId();
                List<SecondaryMenuDTO> secondaryMenus = permissionMapper.selectSecondaryMenuByStairId(parentId, roleId);

                if (secondaryMenus.size() > 0) {

                    for (SecondaryMenuDTO secondaryMenu : secondaryMenus){

                        parentId = secondaryMenu.getId();

                        List<ApiDTO> apis = permissionMapper.selectApiBySecondaryMenuId(parentId,roleId);

                        if (apis.size()>0)
                            secondaryMenu.setApis(apis);
                    }
                    stair.setSecondaryMenus(secondaryMenus);
                }
            }
        } else
            return null;
        return stairMenus;
    }
}

package com.inet.code.service;

import com.inet.code.entity.Character;
import com.inet.code.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface RoleService extends IService<Role> {

    /**
     * 通过权限的名字去获取权限的uuid
     * @author HCY
     * @since 2020-11-18
     * @param roleName 权限名称
     * @return Character 实体类
     */
    Role getByRoleName(String roleName);
}

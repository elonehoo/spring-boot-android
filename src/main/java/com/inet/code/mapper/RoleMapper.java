package com.inet.code.mapper;

import com.inet.code.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 通过权限的名称获取权限的实体类
     * @author HCY
     * @since 2020-11-18
     * @param roleName 权限名称
     * @return Role 实体类
     */
    Role getByRoleName(String roleName);
}

package com.inet.code.mapper;

import com.inet.code.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 登录操作
     * @param account 账号
     * @param password 密码
     * @return User实体类
     */
    User getLogin(String account, String password);
}

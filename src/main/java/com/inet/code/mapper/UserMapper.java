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

    /**
     * 通过学号判断用户是否存在
     * @author HCY
     * @since 2020-11-18
     * @param number 学号
     * @return User 实体类
     */
    User getByNumber(String number);
    /**
     * 通过学号删除用户
     * @author HCY
     * @since 2020/11/20 7:52 上午
     * @param number:
     * @return java.lang.Boolean
    */
    Boolean removeByNumber(String number);
}

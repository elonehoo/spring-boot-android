package com.inet.code.service;

import com.inet.code.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.code.utlis.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface UserService extends IService<User> {

    /**
     * 登录操作
     * @author HCY
     * @since 2020-11-17
     * @param account 账号
     * @param password 密码
     * @param path URL路径
     * @return Result风格
     */
    Result getLogin(String account, String password, String path);

    /**
     * 注册操作
     * @param name 姓名
     * @param buddha 头像
     * @param phone 电话
     * @param number 学号
     * @param password 密码
     * @param clazz 班级
     * @param path URL路径
     * @return Result风格
     */
    Result getEnroll(
              String name
            , String buddha
            , String phone
            , String number
            , String password
            , String clazz
            , String path);

    /**
     * 退出操作
     * @author HCY
     * @since 2020-11-18
     * @param token 令牌
     * @param path URL路径
     * @return Result风格
     */
    Result getExit(String token, String path);
}

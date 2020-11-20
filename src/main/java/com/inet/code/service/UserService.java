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

    /**
     * 签到操作
     * @author HCY
     * @since 2020-11-18
     * @param token 令牌
     * @param path URL路径
     * @return Result风格
     */
    Result getSign(String token, String path);

    /**
     * 展示校园风景
     * @param pagination 页数
     * @param entry 条目数
     * @param path URL路径
     * @return Result风格
     */
    Result getDemonstrate(Integer pagination, Integer entry, String path);

    /**
     * 展示信息推送
     * @author HCY
     * @since 2020-11-18
     * @param pagination 页数
     * @param entry 条目数
     * @param path URL路径
     * @return Result风格
     */
    Result getInfo(Integer pagination, Integer entry, String path);

    /**
     * 展示学生信息
     * @author HCY
     * @since 2020/11/19 8:16 下午
     * @param pagination:
     * @param entry:
     * @param path:
     * @return com.inet.code.utlis.Result
    */
    Result getDisplay(Integer pagination, Integer entry, String path);

    /**
     * 修改用户信息
     * @author HCY
     * @since 2020/11/19 8:39 下午
     * @param token: 令牌
     * @param buddha: 头像
     * @param phone: 电话号码
     * @param oldPassword: 旧密码
     * @param newPassword: 新密码
     * @param clazz: 班级
     * @param path: URL路径
     * @return com.inet.code.utlis.Result
    */
    Result getModifyUser(
              String token
            , String buddha
            , String phone
            , String oldPassword
            , String newPassword
            , String clazz
            , String path);

    /**
     * 删除用户
     * @author HCY
     * @since 2020/11/19 9:49 下午
     * @param number: 学号
     * @param path: URL路径
     * @return com.inet.code.utlis.Result
    */
    Result getCancel(String number, String path);
}

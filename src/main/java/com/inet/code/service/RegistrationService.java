package com.inet.code.service;

import com.inet.code.entity.Registration;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface RegistrationService extends IService<Registration> {
    /**
     * 通过学号进行签到查询
     * @author HCY
     * @since 2020-11-18
     * @param userNumber 学号
     * @return Registration 实体类
     */
    Registration getByNumber(String userNumber);
    /**
     * 通过学号删除用户的签到
     * @author HCY
     * @since 2020/11/20 7:57 上午
     * @param number: 学号
     * @return java.lang.Boolean
    */
    Boolean removeByNumber(String number);
}

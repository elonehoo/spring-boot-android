package com.inet.code.mapper;

import com.inet.code.entity.Registration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface RegistrationMapper extends BaseMapper<Registration> {
    /**
     * 通过学号进行查询用户的签到状态
     * @author HCY
     * @since 2020-11-18
     * @param userNumber
     * @return
     */
    Registration getByNumber(String userNumber);
    /**
     * 通过学号删除用户的签到
     * @author HCY
     * @since 2020/11/20 7:58 上午
     * @param number: 学号
     * @return java.lang.Boolean
    */
    Boolean removeByNumber(String number);
}

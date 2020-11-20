package com.inet.code.service.impl;

import com.inet.code.entity.Registration;
import com.inet.code.mapper.RegistrationMapper;
import com.inet.code.service.RegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements RegistrationService {

    @Resource
    private RegistrationMapper registrationMapper;

    /**
     * 通过学号进行签到查询
     * @author HCY
     * @since 2020-11-18
     * @param userNumber 学号
     * @return Registration 实体类
     */
    @Override
    public Registration getByNumber(String userNumber) {
        return registrationMapper.getByNumber(userNumber);
    }
    /**
     * 通过学号删除用户的签到
     * @author HCY
     * @since 2020/11/20 7:57 上午
     * @param number: 学号
     * @return java.lang.Boolean
     */
    @Override
    public Boolean removeByNumber(String number) {
        return registrationMapper.removeByNumber(number);
    }
}

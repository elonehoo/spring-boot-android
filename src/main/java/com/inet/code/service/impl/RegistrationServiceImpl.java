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

    @Override
    public Registration getByNumber(String userNumber) {
        return registrationMapper.getByNumber(userNumber);
    }
}

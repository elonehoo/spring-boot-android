package com.inet.code.service.impl;

import com.inet.code.entity.Cipher;
import com.inet.code.mapper.CipherMapper;
import com.inet.code.service.CipherService;
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
public class CipherServiceImpl extends ServiceImpl<CipherMapper, Cipher> implements CipherService {

    @Resource
    private CipherMapper cipherMapper;
    /**
     * 通过学号查找密码
     * @author HCY
     * @since 2020/11/20 7:53 上午
     * @param userNumber: 学号
     * @return com.inet.code.entity.Cipher
    */
    @Override
    public Cipher getByNumber(String userNumber) {
        return cipherMapper.getByNumber(userNumber);
    }
    /**
     * 通过学号删除密码
     * @author HCY
     * @since 2020/11/20 7:54 上午
     * @param number: 学号
     * @return java.lang.Boolean
    */
    @Override
    public Boolean removeByNumber(String number) {
        return cipherMapper.removeByNumber(number);
    }
}

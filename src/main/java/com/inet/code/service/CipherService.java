package com.inet.code.service;

import com.inet.code.entity.Cipher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface CipherService extends IService<Cipher> {
    /**
     * 通过学号查找密码实体类
     * @author HCY
     * @since 2020/11/19 9:01 下午
     * @param userNumber: 学号
     * @return com.inet.code.entity.Cipher
    */
    Cipher getByNumber(String userNumber);
}

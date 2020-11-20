package com.inet.code.mapper;

import com.inet.code.entity.Cipher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface CipherMapper extends BaseMapper<Cipher> {

    /**
     * 通过学号查找密码
     * @author HCY
     * @since 2020/11/19 9:03 下午
     * @param userNumber:
     * @return com.inet.code.entity.Cipher
    */
    Cipher getByNumber(String userNumber);
    /**
     * 通过学号删除密码
     * @author HCY
     * @since 2020/11/20 7:54 上午
     * @param number: 学号
     * @return java.lang.Boolean
    */
    Boolean removeByNumber(String number);
}

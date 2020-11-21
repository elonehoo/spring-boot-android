package com.inet.code.mapper;

import com.inet.code.entity.Character;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface CharacterMapper extends BaseMapper<Character> {

    /**
    * 删除用户的权限
    * @author HCY
    * @since 2020/11/21 下午 03:56
    * @param number: 学号
    * @return java.lang.Boolean
    */
    Boolean removeByNumber(String number);
}

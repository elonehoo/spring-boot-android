package com.inet.code.service;

import com.inet.code.entity.Character;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface CharacterService extends IService<Character> {

    /**
    * 删除用户的权限
    * @author HCY
    * @since 2020/11/21 下午 03:56
    * @param number: 学号
    * @return java.lang.Boolean
    */
    Boolean removeByNumber(String number);
}

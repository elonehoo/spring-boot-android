package com.inet.code.service.impl;

import com.inet.code.entity.Character;
import com.inet.code.mapper.CharacterMapper;
import com.inet.code.service.CharacterService;
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
public class CharacterServiceImpl extends ServiceImpl<CharacterMapper, Character> implements CharacterService {

    @Resource
    private CharacterMapper characterMapper;

}

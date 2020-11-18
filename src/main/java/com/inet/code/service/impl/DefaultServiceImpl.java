package com.inet.code.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.inet.code.entity.Default;
import com.inet.code.mapper.DefaultMapper;
import com.inet.code.service.DefaultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HCY
 * @since 2020-11-18
 */
@Service
public class DefaultServiceImpl extends ServiceImpl<DefaultMapper, Default> implements DefaultService {

    @Resource
    private DefaultMapper defaultMapper;

    /**
     * 随机创建一个Default的实体类
     * @author HCY
     * @since 2020-11-18
     * @return Default 实体类
     */
    @Override
    public Default getRandomImagesUrl() {
        return defaultMapper.getRandomImagesUrl(RandomUtil.randomInt(0, this.count() - 1));
    }
}

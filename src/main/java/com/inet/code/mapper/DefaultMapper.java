package com.inet.code.mapper;

import com.inet.code.entity.Default;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2020-11-18
 */
public interface DefaultMapper extends BaseMapper<Default> {
    /**
     * 寻找头像的实体类
     * @author HCY
     * @since 2020-11-18
     * @param randomInt 随机数字
     * @return Default 实体类
     */
    Default getRandomImagesUrl(int randomInt);
}

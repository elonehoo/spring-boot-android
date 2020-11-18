package com.inet.code.service;

import com.inet.code.entity.Default;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCY
 * @since 2020-11-18
 */
public interface DefaultService extends IService<Default> {
    /**
     * 随机创建一个Default的实体类
     * @author HCY
     * @since 2020-11-18
     * @return Default 实体类
     */
    Default getRandomImagesUrl();
}

package com.inet.code.service;

import com.inet.code.entity.Exhibition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.code.utlis.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
public interface ExhibitionService extends IService<Exhibition> {

    /**
     * 上传图片
     * @author HCY
     * @since 2020-11-18
     * @param city 校园位置
     * @param images 图片的URL地址
     * @param path URL路径
     * @return Result风格
     */
    Result getUploading(String city, String images, String path);
}

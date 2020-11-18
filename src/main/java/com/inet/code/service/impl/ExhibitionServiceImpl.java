package com.inet.code.service.impl;

import com.inet.code.entity.Exhibition;
import com.inet.code.mapper.ExhibitionMapper;
import com.inet.code.service.ExhibitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.utlis.Result;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
@Service
public class ExhibitionServiceImpl extends ServiceImpl<ExhibitionMapper, Exhibition> implements ExhibitionService {

    /**
     * 上传图片
     * @author HCY
     * @since 2020-11-18
     * @param city 校园位置
     * @param images 图片的URL地址
     * @param path URL路径
     * @return Result风格
     */
    @Override
    public Result getUploading(String city, String images, String path) {
        //创建实体类
        Exhibition exhibition = new Exhibition();
        //设置图片地点
        exhibition.setExhibitionCity(city);
        //设置图片的URL路径
        exhibition.setExhibitionImages(images);
        //创建时间和修改时间
        exhibition.setExhibitionCreation(new Date());
        exhibition.setExhibitionModification(new Date());
        //进行存储
        this.save(exhibition);
        return new Result(
                  Result.STATUS_OK_200
                , Result.INFO_OK_200
                , Result.DETAILS_OK_200
                , "存储成功"
                , path );
    }
}

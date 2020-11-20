package com.inet.code.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.inet.code.entity.Exhibition;
import com.inet.code.mapper.ExhibitionMapper;
import com.inet.code.service.ExhibitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.utlis.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    private ExhibitionMapper exhibitionMapper;

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

    /**
     * 通过uuid删除图片
     * @author HCY
     * @since 2020/11/20 9:41 上午
     * @param uuid: 序号
     * @param path: URL路径
     * @return com.inet.code.utlis.Result
    */
    @Override
    public Result remobeByuuid(String uuid, String path) {
        if (this.removeById(uuid)) {
            return new Result().result200("删除成功",path);
        }
        return new Result().result500("删除失败",path);
    }
}

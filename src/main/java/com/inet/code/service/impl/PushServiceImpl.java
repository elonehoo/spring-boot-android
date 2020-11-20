package com.inet.code.service.impl;

import com.inet.code.entity.Push;
import com.inet.code.mapper.PushMapper;
import com.inet.code.service.PushService;
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
public class PushServiceImpl extends ServiceImpl<PushMapper, Push> implements PushService {

    @Resource
    private PushMapper pushMapper;

    /**
     * 推送信息
     * @param headline 标题
     * @param content 内容
     * @param path URL路径
     * @return Result风格
     */
    @Override
    public Result getSend(String headline, String content, String path) {
        //创建实体类
        Push push = new Push();
        //创建标题
        push.setPushHeadline(headline);
        //创建内容
        push.setPushContent(content);
        //创建时间和修改时间
        push.setPushCreation(new Date());
        push.setPushModification(new Date());
        //进行存储
        this.save(push);
        return new Result(
                 Result.STATUS_OK_200
                ,Result.INFO_OK_200
                ,Result.DETAILS_OK_200
                ,"存储成功"
                ,path);
    }
    /**
     * 通过uuid删除推文
     * @author HCY
     * @since 2020/11/20 9:38 上午
     * @param uuid: 序号
     * @param path: URL路径
     * @return com.inet.code.utlis.Result
    */
    @Override
    public Result removeByuuid(String uuid,String path) {
        //判断删除是否成功
        if (this.removeById(uuid)) {
            return new Result().result200("删除成功",path);
        }
        return new Result().result500("删除失败",path);
    }
}

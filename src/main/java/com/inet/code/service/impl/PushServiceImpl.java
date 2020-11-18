package com.inet.code.service.impl;

import com.inet.code.entity.Push;
import com.inet.code.mapper.PushMapper;
import com.inet.code.service.PushService;
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
public class PushServiceImpl extends ServiceImpl<PushMapper, Push> implements PushService {

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
}

package com.inet.code.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.inet.code.entity.User;
import com.inet.code.mapper.UserMapper;
import com.inet.code.service.CipherService;
import com.inet.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.utlis.JwtUtils;
import com.inet.code.utlis.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private CipherService cipherService;

    /**
     * 登录操作
     * @author HCY
     * @since 2020-11-17
     * @param account 账号
     * @param password 密码
     * @param path URL路径
     * @return Result风格
     */
    @Override
    public Result getLogin(String account, String password, String path) {
        User user = userMapper.getLogin(account, DigestUtil.md5Hex(password));
        //账号或者密码错误
        if (user == null){
            return new Result(
                    Result.STATUS_NOT_FOUND_404
                    ,Result.INFO_NOT_FOUND_404
                    ,Result.DETAILS_NOT_FOUND_404
                    ,"您的账号或者密码错误"
                    ,path);
        }
        //产生token的数据
        Map<String, String> map = new HashMap<>(2);
        map.put("userName",user.getUserName());
        map.put("userId",user.getUserUuid());
        //产生 token
        String token = JwtUtils.getToken(map);
        //存入 Redis
        redisTemplate.opsForValue().set(token,user,7, TimeUnit.DAYS);
        //创建返回值
        Map<String, String> results = new HashMap<>(2);
        results.put("info","登录成功");
        results.put("token",token);
        return new Result(
                Result.STATUS_OK_200
                ,Result.INFO_OK_200
                ,"成功"
                ,results
                ,path);
    }
}

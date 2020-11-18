package com.inet.code.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.inet.code.entity.Character;
import com.inet.code.entity.Cipher;
import com.inet.code.entity.Registration;
import com.inet.code.entity.User;
import com.inet.code.mapper.UserMapper;
import com.inet.code.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.utlis.JwtUtils;
import com.inet.code.utlis.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private CipherService cipherService;

    @Resource
    private DefaultService defaultService;

    @Resource
    private RoleService roleService;

    @Resource
    private CharacterService characterService;

    @Resource
    private RegistrationService registrationService;

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

    /**
     * 注册操作
     * @param name 姓名
     * @param buddha 头像
     * @param phone 电话
     * @param number 学号
     * @param password 密码
     * @param clazz 班级
     * @param path URL路径
     * @return Result风格
     */
    @Override
    public Result getEnroll(String name, String buddha, String phone, String number, String password , String clazz, String path) {
        //对于信息的判断
        //判断学号是否被注册了
        if (userMapper.getByNumber(number) != null) {
            return new Result(
                     Result.STATUS_BAN_403
                    ,Result.INFO_BAN_403
                    ,Result.DETAILS_BAN_403
                    ,"学号已经被注册了"
                    ,path);
        }
        //判断名字是否全部带中文
        if (!Validator.isChinese(name)){
            return new Result(
                    Result.STATUS_ILLEGAL_401
                    ,Result.INFO_ILLEGAL_401
                    ,Result.DETAILS_ILLEGAL_401
                    ,"名字中带有了非中文的字符，请重新输入"
                    ,path);
        }
        //判断头像是否为空，不为应该为头像的URL地址
        if (StrUtil.hasEmpty(buddha)){
            buddha = defaultService.getRandomImagesUrl().getDefaultUrl();
        }
        //判断电话号码是否正确
        if (! Validator.isMobile(phone)){
            return new Result(
                    Result.STATUS_ILLEGAL_401
                    ,Result.INFO_ILLEGAL_401
                    ,Result.DETAILS_ILLEGAL_401
                    ,"输入的电话号码不正确，请重新输入"
                    ,path);
        }
        //判断学号是否为空
        if (StrUtil.hasEmpty(number)){
            return new Result(
                    Result.STATUS_NOT_FOUND_404
                    ,Result.INFO_NOT_FOUND_404
                    ,Result.DETAILS_NOT_FOUND_404
                    ,"学号没有输入哦！"
                    ,path);
        }
        //判断班级是否为空
        if(StrUtil.hasEmpty(clazz)){
            return new Result(
                    Result.STATUS_NOT_FOUND_404
                    ,Result.INFO_NOT_FOUND_404
                    ,Result.DETAILS_NOT_FOUND_404
                    ,"班级没有输入哦！"
                    ,path);
        }
        //判断密码是否符合规范
        if(! Validator.isGeneral(password)){
            return new Result(
                     Result.STATUS_BAN_403
                    ,Result.INFO_BAN_403
                    ,Result.DETAILS_BAN_403
                    ,"密码不符合规范，需要包含英文字母和数字"
                    ,path);
        }
        //进行存储用户
        User user = new User();
        //设置用户姓名
        user.setUserName(name);
        //设置用户的头像
        user.setUserBuddha(buddha);
        //设置用户的电话
        user.setUserPhone(phone);
        //设置用户的学号
        user.setUserNumber(number);
        //设置用户的班级
        user.setUserClass(clazz);
        //设置用户的创建和修改时间
        user.setUserCreation(new Date());
        user.setUserModification(new Date());
        //存储
        this.save(user);
        //进行密码的存储
        Cipher cipher = new Cipher();
        //设置用户的学号
        cipher.setCipherNumber(number);
        //设置用户的密码进行加密
        cipher.setCipherPassword(DigestUtil.md5Hex(password));
        //设置创建和修改的时间
        cipher.setCipherModification(new Date());
        cipher.setCipherCreation(new Date());
        //存储密码
        cipherService.save(cipher);
        //设置用户的权限
        Character character = new Character();
        //设置学生的学号
        character.setCharacterNumber(number);
        //设置学生的权限
        character.setCharacterRoleUuid(roleService.getByRoleName("student").getRoleUuid());
        character.setCharacterCreation(new Date());
        character.setCharacterModification(new Date());
        //进行存储
        characterService.save(character);
        //存储签到信息
        Registration registration = new Registration();
        //设置学号
        registration.setRegistrationNumber(number);
        //设置签到的总时长
        registration.setRegistrationTotal(0L);
        //存储签到状态为false
        registration.setRegistrationState("false");
        //设置创建时间，修改时间
        registration.setRegistrationCreation(new Date());
        registration.setRegistrationModification(new Date());
        //进行存储
        registrationService.save(registration);
        return new Result(
                 Result.STATUS_OK_200
                ,Result.INFO_OK_200
                ,Result.DETAILS_OK_200
                ,"注册成功"
                ,path);
    }

    /**
     * 退出操作
     * @author HCY
     * @since 2020-11-18
     * @param token 令牌
     * @param path URL路径
     * @return Result风格
     */
    @Override
    public Result getExit(String token, String path) {
        redisTemplate.delete(token);
        return new Result(
                Result.STATUS_OK_200
                ,Result.INFO_OK_200
                ,Result.DETAILS_OK_200
                ,"退出成功！"
                ,path);
    }
}

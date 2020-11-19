package com.inet;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.system.SystemUtil;
import com.inet.code.service.DefaultService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class InetApplicationTests {
    @Resource
    private DefaultService defaultService;

    @Test
    void contextLoads() {
        System.out.println(IdUtil.randomUUID());
    }
    @Test
    void contextLoads_1(){
        System.out.println(DigestUtil.md5Hex("123"));
    }
    @Test
    void contextLoads_2(){
        System.out.println(Validator.isChinese("晓寻遥"));     //true
        System.out.println(Validator.isChinese("1晓寻遥1"));   //false
    }
    @Test
    void contextLoads_3(){
        String str = "123";
        String a = "";
        System.out.println(StrUtil.hasEmpty(str));      //false
        System.out.println(StrUtil.hasEmpty(a));        //true
    }
    @Test
    void contextLoads_4(){
        System.out.println(defaultService.getRandomImagesUrl().getDefaultUrl());
    }

    @Test
    void contextLoads_5(){
        System.out.println(Validator.isMobile("12312313"));
        System.out.println(Validator.isMobile("17605818915"));
    }
    @Test
    void contextLoads_6(){
        String password = "";
        System.out.println(Validator.isGeneral(password));
    }

    @Test
    void setDefaultService(){
        System.out.println(SystemUtil.getHostInfo());
    }

}

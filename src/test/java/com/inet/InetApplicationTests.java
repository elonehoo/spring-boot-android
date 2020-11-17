package com.inet;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InetApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(IdUtil.randomUUID());
    }
    @Test
    void contextLoads_1(){
        System.out.println(DigestUtil.md5Hex("123"));
    }

}

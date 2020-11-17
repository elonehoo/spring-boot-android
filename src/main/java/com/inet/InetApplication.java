package com.inet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主类
 * @author HCY
 * @since 2020-11-17
 */
@SpringBootApplication
@MapperScan("com.inet.code.mapper")
public class InetApplication {

    public static void main(String[] args) {
        SpringApplication.run(InetApplication.class, args);
    }

}

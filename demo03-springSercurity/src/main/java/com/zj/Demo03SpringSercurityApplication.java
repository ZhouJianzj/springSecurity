package com.zj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zj.mapper")
@SpringBootApplication
public class Demo03SpringSercurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo03SpringSercurityApplication.class, args);
    }

}

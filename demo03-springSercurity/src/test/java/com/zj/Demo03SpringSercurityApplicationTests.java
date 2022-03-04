package com.zj;

import com.zj.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class Demo03SpringSercurityApplicationTests {

    @Autowired
    UserMapper userMapper;

    /**
     * 测试数据库
     */
    @Test
    void contextLoads() {
        System.out.println(userMapper.findUserByName("user"));
    }

    /**
     * 生成加密之后的密码
     */
    @Test
    void encode() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("123");
        System.out.println(password);
    }

}

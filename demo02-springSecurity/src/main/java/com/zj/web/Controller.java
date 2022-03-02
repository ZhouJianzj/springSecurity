package com.zj.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoujian
 */

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Controller {


    @GetMapping("/")
    public String home (){
        return "hello spring boot security";
    }

    /**
     * 只有角色是admin的用户才可访问
     * \
     * 两个注解的使用
     * @EnableGlobalMethodSecurity(prePostEnabled = true)
     * @PreAuthorize("hasRole('admin')")
     * @return
     */
    @GetMapping("/hello")
    @PreAuthorize("hasRole('admin')")
    public String hello (){
        return "hello  admin";
    }

    /**
     * 只能是user角色的用户访问
     * @return
     */
    @GetMapping("/hello1")
    @PreAuthorize("hasRole('user')")
    public String hello1 (){
        return "hello  user";
    }
}

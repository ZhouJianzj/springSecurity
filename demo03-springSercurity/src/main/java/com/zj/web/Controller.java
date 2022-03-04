package com.zj.web;

import org.apache.catalina.User;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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


//    //在控制器执行的之前权限验证
//    @PreAuthorize("")
//
//    //在控制器执行之后权限验证
//    @PostAuthorize("")
//
//    //对集合传入参数的过滤
//    @PreFilter("")
//
//    //对集合返回值参数的过滤
//    @PostFilter("")

    @GetMapping("/test")
    public String test (){
        String userDetails = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            userDetails = ((UserDetails)principal).getUsername();
        }else {
            userDetails = principal.toString();
        }
        return userDetails;
    }
}

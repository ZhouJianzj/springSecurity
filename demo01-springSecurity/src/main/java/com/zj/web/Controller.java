package com.zj.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoujian
 */

@RestController
public class Controller {


    @GetMapping("/")
    public String home (){
        return "hello spring boot security";
    }
    @GetMapping("/hello")
    public String hello (){
        return "hello ";
    }
}

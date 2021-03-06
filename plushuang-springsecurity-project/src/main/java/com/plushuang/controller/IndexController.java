package com.plushuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
    @GetMapping("toLoginForm")
    public String toLoginForm(){
        return "views/login";
    }

    @GetMapping("/level1/{id}")
    public String level1(@PathVariable("id")int id){
        return "views/level1"+"/"+id;
    }
    @GetMapping("/level2/{id}")
    public String level2(@PathVariable("id")int id){
        return "views/level2"+"/"+id;
    }
    @GetMapping("/level3/{id}")
    public String level3(@PathVariable("id")int id){
        return "views/level3"+"/"+id;
    }
}

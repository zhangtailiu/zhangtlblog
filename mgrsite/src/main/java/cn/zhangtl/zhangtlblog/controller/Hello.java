package cn.zhangtl.zhangtlblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

    @RequestMapping("hello")
    public String hello(){
        return "index.html";
    }
}

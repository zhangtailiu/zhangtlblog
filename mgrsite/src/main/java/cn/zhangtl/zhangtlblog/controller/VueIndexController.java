package cn.zhangtl.zhangtlblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VueIndexController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
}

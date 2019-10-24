package cn.zhangtl.zhangtlblog.controller;

import cn.zhangtl.zhangtlblog.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user);
        return "success";
    }
}

package cn.zhangtl.zhangtlblog.controller;

import cn.zhangtl.zhangtlblog.domain.Acount;
import cn.zhangtl.zhangtlblog.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody Acount user){
        Integer count = loginService.selctAcountForLogin(user);
        if(count != null && count >0){
            return "success";
        }else {
            return "false";
        }
    }
}

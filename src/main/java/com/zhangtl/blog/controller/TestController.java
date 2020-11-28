package com.zhangtl.blog.controller;

import com.zhangtl.blog.service.ITestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {

    private ITestService testService;

    @GetMapping("/getUser")
    public Object test(){
        if("1".equals(testService.test())){
            return "登录成功";
        }
        return "登录失败";
    }
}

package com.zhangtl.blog.controller;

import com.zhangtl.blog.service.ITestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {

    private ITestService testService;

    @GetMapping("/test")
    public Object test(){
        return testService.test();
    }
}

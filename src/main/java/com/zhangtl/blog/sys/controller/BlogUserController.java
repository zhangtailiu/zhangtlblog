package com.zhangtl.blog.sys.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangtl
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/sys/blog-user")
@Api(value = "/user",tags = "用户登录")
public class BlogUserController {

}

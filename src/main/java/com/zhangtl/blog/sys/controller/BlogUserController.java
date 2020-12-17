package com.zhangtl.blog.sys.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhangtl.blog.sys.entity.BlogUser;
import com.zhangtl.blog.sys.service.IBlogUserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
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
@AllArgsConstructor
public class BlogUserController {

    private IBlogUserService blogUserService;


    @GetMapping("/login")
    public Object login(@Validated BlogUser blogUser){
        BlogUser one = blogUserService.getOne(Wrappers.<BlogUser>lambdaQuery()
                .eq(BlogUser::getUsername, blogUser.getUsername())
                .eq(BlogUser::getPassword, blogUser.getPassword()));
        if(one == null){
            return "登录失败";
        }
        return one;
    }


}

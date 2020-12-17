package com.zhangtl.blog.base.security.service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhangtl.blog.sys.entity.BlogUser;
import com.zhangtl.blog.sys.service.IBlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
/*
* spring security 用户校验包
* */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IBlogUserService blogUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isBlank(username)){
            throw new RuntimeException("用户不能为空");
        }
        BlogUser user = blogUserService.getOne(Wrappers.<BlogUser>lambdaQuery().eq(BlogUser::getUsername, username));
        if(user == null){
            throw new RuntimeException("当前用户不存在");
        }
        return new User(username,
                passwordEncoder.encode(user.getPassword()),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
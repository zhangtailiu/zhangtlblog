package com.zhangtl.blog.base.security.config;

import com.zhangtl.blog.base.security.handler.CustomizeAuthenticationFailureHandler;
import com.zhangtl.blog.base.security.handler.CustomizeAuthenticationSuccessHandler;
import com.zhangtl.blog.base.security.handler.CustomizeLogoutSuccessHandler;
import com.zhangtl.blog.base.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * spring security 验证配置
 * */
@Configuration
@EnableWebSecurity
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //匿名用户访问无权限资源时的异常
    @Autowired
    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;
    //登录成功处理
    @Autowired
    private CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;
    //登录失败处理逻辑;
    @Autowired
    private CustomizeAuthenticationFailureHandler authenticationFailureHandler;
    //登出成功处理逻辑
    @Autowired
    private CustomizeLogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sys/blog-user/login").hasAuthority("query_user")
                .and().exceptionHandling().
                authenticationEntryPoint(authenticationEntryPoint)
                //登录逻辑
                .and()
                .formLogin().
                permitAll().//允许所有用户
                successHandler(authenticationSuccessHandler).//登录成功处理逻辑
                failureHandler(authenticationFailureHandler)//登录失败处理逻辑;
                //登出
                .and().logout().
                permitAll().//允许所有用户
                logoutSuccessHandler(logoutSuccessHandler).//登出成功处理逻辑
                deleteCookies("JSESSIONID")//登出之后删除cookie
                .and().csrf().disable();
//           http
                   /*前后端不分离的方式*/
//                .formLogin() // 表单方式
//                .loginPage("/login.html") // 指定登录页
//                .loginProcessingUrl("/login") // 指定登录处理url
//                .and()
//                .authorizeRequests() //请求配置
//                .antMatchers("/getUser").permitAll() // 放行/login.html
//                .anyRequest() //任何请求
//                .authenticated()// 都需要认证
//                .and().exceptionHandling()//异常处理(权限拒绝、登录失效等)
//                .authenticationEntryPoint(authenticationEntryPoint)//匿名用户访问无权限资源时的异常
//                .and().csrf().disable(); // 关闭csrf
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new MyUserDetailsService();
    }

    /*
     * 配置自定义用户验证方式
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式
        auth.userDetailsService(userDetailsService());
    }
}
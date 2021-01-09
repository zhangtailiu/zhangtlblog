package com.zhangtl.blog.sys.util;

import com.zhangtl.blog.base.sys.UserMessage;
import com.zhangtl.blog.sys.entity.BlogUser;

import java.util.Optional;

public class AuthUtil {


    public  static String getUserName(){
        return Optional.ofNullable(UserMessage.getBlogUser()).map(BlogUser::getUsername).orElse("未登录");
    }

}

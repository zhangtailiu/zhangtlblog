package com.zhangtl.blog.base.sys;

import com.zhangtl.blog.sys.entity.BlogUser;

public class UserMessage {
    public static BlogUser blogUser;

    public static void setBlogUser(BlogUser blogUser) {
        blogUser = blogUser;
    }

    public  static BlogUser getBlogUser() {
        return blogUser;
    }
}

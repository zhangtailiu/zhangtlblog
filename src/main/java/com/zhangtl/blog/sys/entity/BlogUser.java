package com.zhangtl.blog.sys.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangtl
 * @since 2020-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BlogUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户编码
     */
    private String code;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String headImage;


}

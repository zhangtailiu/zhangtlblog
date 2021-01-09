package com.zhangtl.blog.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

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
@TableName("blog_user")
public class BlogUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不可为空")
    private String username;

    /**
     * 用户编码
     */
    private String code;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不可为空")
    private String password;

    /**
     * 用户头像
     */
    private String headImage;


}

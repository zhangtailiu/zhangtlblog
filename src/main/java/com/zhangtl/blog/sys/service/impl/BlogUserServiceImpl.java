package com.zhangtl.blog.sys.service.impl;

import com.zhangtl.blog.sys.entity.BlogUser;
import com.zhangtl.blog.sys.mapper.BlogUserMapper;
import com.zhangtl.blog.sys.service.IBlogUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangtl
 * @since 2020-11-28
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements IBlogUserService {

}

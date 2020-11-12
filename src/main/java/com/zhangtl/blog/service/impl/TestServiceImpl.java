package com.zhangtl.blog.service.impl;

import com.zhangtl.blog.mapper.TestMapper;
import com.zhangtl.blog.service.ITestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestServiceImpl implements ITestService {
    private TestMapper testMapper;
    @Override
    public Object test() {
        return testMapper.test();
    }
}

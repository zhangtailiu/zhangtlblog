package cn.zhangtl.zhangtlblog.service.impl;

import cn.zhangtl.zhangtlblog.domain.Acount;
import cn.zhangtl.zhangtlblog.mapper.AcountMapper;
import cn.zhangtl.zhangtlblog.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private AcountMapper acountMapper;
    @Override
    public Integer selctAcountForLogin(Acount user) {
        return acountMapper.selectCount(user);
    }
}

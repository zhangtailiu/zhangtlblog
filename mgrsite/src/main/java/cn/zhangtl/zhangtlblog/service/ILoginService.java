package cn.zhangtl.zhangtlblog.service;

import cn.zhangtl.zhangtlblog.domain.Acount;

public interface ILoginService {
    Integer selctAcountForLogin(Acount user);
}

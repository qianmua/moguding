package com.qianmua.service.impl;

import com.qianmua.framework.support.Assert;
import com.qianmua.method.LoginMapper;
import com.qianmua.method.SinginMapper;
import com.qianmua.entity.Login;
import com.qianmua.entity.Singin;
import com.qianmua.service.UserService;
import com.qianmua.util.PublicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/10  12:10
 * @description :
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private SinginMapper singinMapper;

    @Override
    public List<Login> queryAllUserInfo() {
        List<Login> logins = loginMapper.selectAll();
        if (logins == null || logins.isEmpty())
            return new ArrayList<>();
        return logins;
    }

    @Override
    public void addUser(Login login) {
        // get planId
        //String plan = getPlanFromDb(login);
        // save to login table
        String replace = PublicUtils.genUUID();
        login.setId(replace);
        loginMapper.insert(login);

        // save to sign table
        Singin singins = login.getSingins();
        String uuid = PublicUtils.genUUID();
        singins.setId(uuid);
        //singins.setPlanId(plan);
        singins.setLoginId(replace);
        singinMapper.insert(singins);

    }

//    private String getPlanFromDb(Login login) {
//        LoginVo loginvo = new LoginVo();
//        BeanUtils.copyProperties(login,loginvo);
//        loginvo.setLoginType(login.getLogintype());
//        String plan = handleSign.getPlan(loginvo);
//        return plan;
//    }


}

package com.qianmua.api;

import com.qianmua.dao.LoginMapper;
import com.qianmua.pojo.Login;
import com.qianmua.pojo.vo.LoginVo;
import com.qianmua.sign.in.SignService;
import com.qianmua.sign.in.SignInServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/11  13:29
 * @description : 这里不打算重构了，在原有的类上面重构，不保留以前的代码
 */
@RestController
@RequestMapping("/api")
public class AutoOption {

    @Autowired
    private SignService signService;
    @Autowired
    private LoginMapper loginMapper;

    @GetMapping("/autoWrite")
    public String autoWrite(){
        List<Login> logins = loginMapper.selectAll();

        logins.forEach( login -> {
            LoginVo loginVo = new LoginVo();
            BeanUtils.copyProperties(login, loginVo);
            String plan = null;

            plan = signService.getPlan(loginVo);

            // option send
            SignInServer signInServer = new SignInServer();

            // auto write
//            signService.autoWrite(plan);
        } );

        return "SUCCESS";
    }
}

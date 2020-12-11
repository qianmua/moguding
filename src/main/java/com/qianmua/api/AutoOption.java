package com.qianmua.api;

import com.qianmua.dao.LoginMapper;
import com.qianmua.pojo.Login;
import com.qianmua.pojo.vo.LoginVo;
import com.qianmua.service.SignService;
import com.qianmua.util.SigninUtil;
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
 * @description :
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

            try {
                plan = signService.getPlan(loginVo);
            } catch (InterruptedException e) {
                System.err.println(" err info -> " + login);
            }

            // option send
            SigninUtil signinUtil = new SigninUtil();

            // auto write




            signService.autoWrite(plan);
        } );

        return "SUCCESS";
    }
}

package com.qianmua.service;

import com.qianmua.entity.Login;

import java.util.List;
/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/10  12:10
 * @description :
 */
public interface UserService {

    /**
     * 获取所有用户信息
     * @return list<loginInfo>
     */
    List<Login> queryAllUserInfo();

    /**
     * 添加用户
     * @param login 登录信息
     */
    void addUser(Login login);
}

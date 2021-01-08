package com.qianmua.service;

import com.qianmua.pojo.Login;

import java.util.List;

public interface Userservice {
    List<Login> getLoginInfo();

    void addUser(Login login);
}

package com.qianmua.controller;

import com.qianmua.entity.Login;
import com.qianmua.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 17:27          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 17:27
 * @since JDK1.8
 */
@RestController
@RequestMapping("/mogu/user")
@Slf4j
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void addUser(Login login) {
        Objects.requireNonNull(login);
        userService.addUser(login);
    }

}

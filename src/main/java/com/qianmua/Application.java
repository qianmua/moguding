package com.qianmua;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.qianmua.dao"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

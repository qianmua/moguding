package com.qianmua;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/10 17:43          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/10 17:43
 * @since JDK1.8
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.qianmua.method"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

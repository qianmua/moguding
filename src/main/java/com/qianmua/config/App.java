package com.qianmua.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/9  16:34
 * @description :
 */
@Configuration
@EnableAspectJAutoProxy
public class App implements WebMvcConfigurer {
}

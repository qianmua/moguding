package com.qianmua.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/9  12:31
 * @description :
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MailNotify {
    boolean needNotify() default true;
}

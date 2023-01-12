package com.qianmua.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/9  15:46
 * @description :
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogNotify {
    boolean needLog() default false;
}

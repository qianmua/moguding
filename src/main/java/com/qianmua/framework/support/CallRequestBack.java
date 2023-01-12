package com.qianmua.framework.support;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  19:30
 * @description : 使用函数式接口
 */
@FunctionalInterface
public interface CallRequestBack {
    void success(String json);
}
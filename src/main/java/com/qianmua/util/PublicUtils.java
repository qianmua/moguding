package com.qianmua.util;

import com.qianmua.constant.Constant;

import java.util.UUID;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/8  9:25
 * @description : 公共工具类
 */
public final class PublicUtils {

    private PublicUtils() {
        throw new RuntimeException(Constant.A01);
    }

    /**
     * gen uuid
     * @return format uuid
     */
    public static final String genUUID(){
        return UUID.randomUUID().toString().replace("-" , "");
    }
}

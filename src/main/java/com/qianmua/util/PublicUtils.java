package com.qianmua.util;

import java.util.UUID;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/8  9:25
 * @description : 公共工具类
 */
public final class PublicUtils {

    public static final String genUUID(){
        return UUID.randomUUID().toString().replace("-" , "");
    }
}

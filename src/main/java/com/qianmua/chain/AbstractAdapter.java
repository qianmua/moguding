package com.qianmua.chain;

import com.qianmua.pojo.vo.SinginVo;

import java.util.function.Consumer;

/**
 * description : 决策 适配器
 *
 * @author jinchao.hu
 * @date 2021/1/25  19:19
 */
public interface AbstractAdapter {
    /**
     * 决策调用
     * @param singinVo 登录信息实体
     * @param token token
     * @param callBack 回调
     */
    void invokeAction(SinginVo singinVo, String token , Consumer<Boolean> callBack);

}

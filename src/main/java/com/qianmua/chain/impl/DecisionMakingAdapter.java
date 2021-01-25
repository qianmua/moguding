package com.qianmua.chain.impl;

import com.qianmua.chain.AbstractAdapter;
import com.qianmua.pojo.vo.SinginVo;

import java.util.function.Consumer;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/1/25  19:45
 */
public class DecisionMakingAdapter implements AbstractAdapter {

    @Override
    public void invokeAction(SinginVo singinVo, String token, Consumer<Boolean> callBack) {

    }
}

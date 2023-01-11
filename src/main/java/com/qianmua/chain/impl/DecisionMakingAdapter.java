package com.qianmua.chain.impl;

import com.qianmua.chain.AbstractAdapter;
import com.qianmua.chain.InvokeHandler;
import com.qianmua.pojo.vo.SinginVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/1/25  19:45
 */
@Service
public class DecisionMakingAdapter implements AbstractAdapter {

    private final List<InvokeHandler> invokeHandlers;

    public DecisionMakingAdapter(List<InvokeHandler> invokeHandlers) {
        this.invokeHandlers = invokeHandlers;
    }


    @Override
    public void invokeAction(SinginVo singinVo, String token, Consumer<Boolean> callBack) {

    }
}

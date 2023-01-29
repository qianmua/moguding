package com.qianmua.chain.impl;

import com.qianmua.chain.AbstractAdapter;
import com.qianmua.chain.InvokeHandler;
import com.qianmua.constant.PublishTypeEnum;
import com.qianmua.entity.vo.SinginVo;
import com.qianmua.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DecisionMakingAdapter implements AbstractAdapter {

    private final List<InvokeHandler> invokeHandlers;

    public DecisionMakingAdapter(List<InvokeHandler> invokeHandlers) {
        this.invokeHandlers = invokeHandlers;
    }

    @Override
    public void invokeAction(SinginVo singinVo, String token,PublishTypeEnum typeEnum , Consumer<Boolean> callBack) {
        // 周报 日报 轮询
        invokeHandlers.forEach( invokeHandler -> {
            LogUtils.logEvent(log , "Sign" , "Execute Sign");
            invokeHandler.execute(singinVo , token , PublishTypeEnum.AUTO_SIGN);

            invokeHandler.execute(singinVo , token , typeEnum);
        });
    }
}

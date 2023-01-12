package com.qianmua.chain.impl;

import com.qianmua.chain.AbstractAdapter;
import com.qianmua.chain.InvokeHandler;
import com.qianmua.constant.AutoManageType;
import com.qianmua.entity.vo.SinginVo;
import com.qianmua.util.DateFormatUtils;
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
    public void invokeAction(SinginVo singinVo, String token, Consumer<Boolean> callBack) {
        // 周报 日报
        invokeHandlers.forEach( invokeHandler -> {
            LogUtils.logEvent(log , "Sign" , "Execute Sign");
            invokeHandler.execute(singinVo , token , AutoManageType.Type.AUTO_SIGN);

            AutoManageType.Type type;
            LogUtils.logCondition(log , "Day Flag" , DateFormatUtils.isDayLast() && !DateFormatUtils.isThisMonthLast());
            if (DateFormatUtils.isDayLast() && !DateFormatUtils.isThisMonthLast()){
                LogUtils.logEvent(log , "1" , "Daily Execute Trigger.");
                type = AutoManageType.Type.AUTO_DAILY;
                invokeHandler.execute(singinVo , token , type);
            }

            LogUtils.logCondition(log , "Month Flag" , DateFormatUtils.isDayLast() && DateFormatUtils.isThisMonthLast());
            if (DateFormatUtils.isDayLast() && DateFormatUtils.isThisMonthLast()){
                LogUtils.logEvent(log , "1" , "Month Execute Trigger.");
                type = AutoManageType.Type.AUTO_MONTHLY;
                invokeHandler.execute(singinVo , token , type);
            }

            LogUtils.logCondition(log , "Week Flag" , DateFormatUtils.isThisWeekSaturday());
            if (DateFormatUtils.isThisWeekSaturday()){
                LogUtils.logEvent(log , "1" , "Week Execute Trigger.");
                type = AutoManageType.Type.AUTO_WEEKLY;
                invokeHandler.execute(singinVo , token , type);
            }

        });
    }
}

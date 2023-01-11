package com.qianmua.handler.impl;

import com.qianmua.chain.InvokeHandler;
import com.qianmua.constant.AutoManageType;
import com.qianmua.pojo.vo.AutoWriteDayInfo;
import com.qianmua.pojo.vo.AutoWriteWeekInfo;
import com.qianmua.pojo.vo.SinginVo;
import com.qianmua.util.DateFormatUtils;
import com.qianmua.util.JsonUtils;
import com.qianmua.util.LogUtils;
import com.qianmua.util.NetworkApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/1/25  19:35
 */
@Component
@Slf4j
public class WeeklyHandle implements InvokeHandler {

    public static final String URL = "";

    @Override
    public void execute(SinginVo singinVo, String token, AutoManageType.Type type) {
        LogUtils.logEvent(log , "SignInVo" , singinVo.toString());
        if (!AutoManageType.Type.AUTO_WEEKLY.equals(type)) {
            return;
        }

        if (!DateFormatUtils.isThisWeekSaturday()){
            return ;
        }

        LogUtils.logEvent(log , "1" , "Build Call Api Params Info.");
        AutoWriteWeekInfo weekInfo = new AutoWriteWeekInfo();
        StringBuilder builder = new StringBuilder();
        builder.append("第");
        builder.append(DateFormatUtils.getStartWithEndTime() / 7 );
        builder.append("周");

        weekInfo.setAttachmentList(new ArrayList<>())
                .setAttachments("")
                .setContent("")
                .setPlanId(singinVo.getPlanId())
                .setReportType(AutoManageType.AUTO__WRITE_WEEK)
                .setTitle(AutoManageType.AUTO_TITLE)
                .setStartTime(DateFormatUtils.getStartDateTime())
                .setEndTime(DateFormatUtils.getEndDateTime())
                .setWeeks(builder.toString());

        LogUtils.logEvent(log , "2" , "Call Api");
        LogUtils.logEvent(log , "weekInfo" , weekInfo.toString());
        NetworkApi.request(JsonUtils.serialize(weekInfo),
                URL,
                token,
                json1 -> { });
    }

}

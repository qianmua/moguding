package com.qianmua.chain.handle;

import com.qianmua.chain.InvokeHandler;
import com.qianmua.constant.AutoManageType;
import com.qianmua.constant.PublishTypeEnum;
import com.qianmua.constant.RandomChickenSoup;
import com.qianmua.entity.vo.AutoWriteWeekInfo;
import com.qianmua.entity.vo.SinginVo;
import com.qianmua.util.DateFormatUtils;
import com.qianmua.util.JsonUtils;
import com.qianmua.util.LogUtils;
import com.qianmua.framework.support.NetworkApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    @Value("${mogu.service.sign-uri}")
    private String uri;

    @Override
    public void execute(SinginVo singinVo, String token, PublishTypeEnum type) {
        LogUtils.logEvent(log , "1" , "Week Execute Trigger.");
        LogUtils.logEvent(log , "SignInVo" , singinVo.toString());
        if (!PublishTypeEnum.AUTO_WEEKLY.equals(type)) {
            return;
        }

        LogUtils.logEvent(log , "1" , "Build Call Api Params Info.");
        AutoWriteWeekInfo weekInfo = new AutoWriteWeekInfo();
        StringBuilder builder = new StringBuilder();
        builder.append("第");
        builder.append(DateFormatUtils.getStartWithEndTime() / 7 );
        builder.append("周");

        weekInfo.setAttachmentList(new ArrayList<>())
                .setAttachments("")
                .setContent(RandomChickenSoup.getRandomChickenSoup())
                .setPlanId(singinVo.getPlanId())
                .setReportType(AutoManageType.AUTO__WRITE_WEEK)
                .setTitle(AutoManageType.AUTO_TITLE)
                .setStartTime(DateFormatUtils.getStartDateTime())
                .setEndTime(DateFormatUtils.getEndDateTime())
                .setWeeks(builder.toString());

        LogUtils.logEvent(log , "2" , "Call Api");
        LogUtils.logEvent(log , "weekInfo" , weekInfo.toString());
        NetworkApi.request(JsonUtils.serialize(weekInfo),
                uri,
                token,
                json1 -> { });
    }

}

package com.qianmua.chain.handle;

import com.qianmua.chain.InvokeHandler;
import com.qianmua.constant.AutoManageType;
import com.qianmua.constant.PublishTypeEnum;
import com.qianmua.constant.RandomChickenSoup;
import com.qianmua.entity.vo.AutoWriteDayInfo;
import com.qianmua.entity.vo.SinginVo;
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
public class DailyHandle implements InvokeHandler {

    @Value("${mogu.service.sign-uri}")
    private String uri;

    @Override
    public void execute(SinginVo singinVo, String token, PublishTypeEnum type) {
        LogUtils.logEvent(log , "1" , "Daily Execute Trigger.");
        LogUtils.logEvent(log , "singInVO" , singinVo.toString());
        if (!PublishTypeEnum.AUTO_DAILY.equals(type)) {
            return;
        }

        LogUtils.logEvent(log , "2" , "Build Req Info.");
        AutoWriteDayInfo info = new AutoWriteDayInfo();
        info.setAttachmentList(new ArrayList<>())
                .setAttachments("")
                .setContent(RandomChickenSoup.getRandomChickenSoup()) // 鸡汤
                .setPlanId(singinVo.getPlanId())
                .setReportType(type.getSymbol())
                .setTitle(AutoManageType.AUTO_TITLE);

        LogUtils.logEvent(log , "3" , "Call API.");
        LogUtils.logEvent(log , "Info" , info.toString());
        NetworkApi.request(
                JsonUtils.serialize(info),
                uri,
                token,
                json1 -> { });
    }
}

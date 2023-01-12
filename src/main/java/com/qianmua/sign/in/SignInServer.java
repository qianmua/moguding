package com.qianmua.sign.in;

import com.google.common.collect.ImmutableList;
import com.qianmua.framework.annotation.LogNotify;
import com.qianmua.framework.annotation.MailNotify;
import com.qianmua.constant.AutoManageType;
import com.qianmua.constant.RandomChickenSoup;
import com.qianmua.mail.ExecuteSendMailFunction;
import com.qianmua.mail.MailServer;
import com.qianmua.entity.User;
import com.qianmua.entity.vo.AutoWriteDayInfo;
import com.qianmua.entity.vo.AutoWriteWeekInfo;
import com.qianmua.entity.vo.LoginVo;
import com.qianmua.entity.vo.SinginVo;
import com.qianmua.util.DateFormatUtils;
import com.qianmua.util.JsonUtils;
import com.qianmua.util.LogUtils;
import com.qianmua.framework.support.NetworkApi;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/8  9:30
 * @description : 执行签到
 */
@Component
@Slf4j
@Deprecated
public class SignInServer {

    @Autowired
    private MailServer mailServer;

    @Value("${mogu.service.sign-uri}")
    private String uri;

    /**
     * sign with
     */
    @LogNotify(needLog = true)
    @MailNotify
    public synchronized void doSign(LoginVo login, final SinginVo singin) {
        LogUtils.logEvent(log , "1" , "Login System");
        String loginurl = uri + "/session/user/v1/login";
        NetworkApi.request(JsonUtils.serialize(login),
                loginurl,
                "",
                json -> {
                    String token = checkToken(json);
                    Objects.requireNonNull(singin.getPlanId());
                    execute(singin, token);
                });
    }

    private void execute(SinginVo singin, String token) {
        doAutoSign(singin, token, status -> {
            if (status!= null && status) {
                mailServer.signMailNotify(builderNotifyMsg(singin));
            }
        });

        autoWrite(singin, token, status -> {
            if (status!= null && status) {
                mailServer.signMailNotify(builderNotifyMsg(singin));
            }
        });
    }

    @NotNull
    private String builderNotifyMsg(SinginVo singin) {
        return new StringBuilder()
                .append("this member planId is :")
                .append(singin.getPlanId())
                .append(",\t if not null then sign success.").toString();
    }


    /**
     * 自动签到
     * @param singin 信息实体
     * @param token token
     */
    private void doAutoSign(SinginVo singin, String token , Consumer<Boolean> booleanConsumer) {
        String sign = uri + "/attendence/clock/v1/save";
        NetworkApi.request(JsonUtils.serialize(singin), sign, token,
                json1 ->
                        mailServer.signMailNotify(
                                builderNotifyMsg(singin)));
    }

    /**
     * 自动日报，周报，月报
     * @param singin 信息实体
     * @param token token
     */
    private void autoWrite(SinginVo singin, String token , Consumer<Boolean> consumer ) {
        String autoWriteUrl = uri + "/practice/paper/v1/save";

        List<ExecuteSendMailFunction> list = Collections.synchronizedList(
                ImmutableList.<ExecuteSendMailFunction>builderWithExpectedSize(3)
                        .add(() -> doAutoWriteDay(singin, token, autoWriteUrl, AutoManageType.AUTO__WRITE_DAY))
                        .add(() -> doAutoWriteWeek(singin, token, autoWriteUrl))
                        .add(() -> doAutoWriteDay(singin, token, autoWriteUrl, AutoManageType.AUTO__WRITE_MONTH))
                        .build()
        );

        list.forEach(esmf ->
                CompletableFuture
                        .supplyAsync(esmf::execute)
                        .thenApply(bool -> consumer )
        );
    }
    /**
     * 自动日报
     */
    @LogNotify(needLog = true)
    private boolean doAutoWriteDay(SinginVo singin, String token, String autoWriteUrl ,String type) {
        if (!DateFormatUtils.isDayLast() || DateFormatUtils.isThisMonthLast()){
            return false;
        }
        AutoWriteDayInfo info = new AutoWriteDayInfo();
        info.setAttachmentList(new ArrayList<>())
                .setAttachments("")
                .setContent(getRandomChickenSoup())
                .setPlanId(singin.getPlanId())
                .setReportType(type)
                .setTitle(AutoManageType.AUTO_TITLE);

        NetworkApi.request(
                JsonUtils.serialize(info),
                autoWriteUrl,
                token,
                json1 -> { });
        return true;
    }

    /**
     * 自动周报
     */
    @LogNotify(needLog = true)
    private boolean doAutoWriteWeek(SinginVo singinVo , String token , String url){

        if (!DateFormatUtils.isThisWeekSaturday()){
            return false;
        }

        AutoWriteWeekInfo weekInfo = new AutoWriteWeekInfo();

        // gen week
        StringBuilder builder = new StringBuilder();
        builder.append("第");
        builder.append(DateFormatUtils.getStartWithEndTime() / 7 );
        builder.append("周");

        weekInfo.setAttachmentList(new ArrayList<>())
                .setAttachments("")
                .setContent(getRandomChickenSoup())
                .setPlanId(singinVo.getPlanId())
                .setReportType(AutoManageType.AUTO__WRITE_WEEK)
                .setTitle(AutoManageType.AUTO_TITLE)
                .setStartTime(DateFormatUtils.getStartDateTime())
                .setEndTime(DateFormatUtils.getEndDateTime())
                .setWeeks(builder.toString());

        NetworkApi.request(JsonUtils.serialize(weekInfo),
                url,
                token,
                json1 -> { });

        return true;
    }

    /**
    鸡汤 - -！
     */
    private String getRandomChickenSoup(){
        return RandomChickenSoup.CHICKEN_SOUP[
                ThreadLocalRandom.current().nextInt(RandomChickenSoup.CHICKEN_SOUP.length)];
    }

    private String checkToken(String json) {
        User parse = JsonUtils.parse(json, User.class);
        return Optional.ofNullable(parse)
                .map(var1 -> var1.getData().getToken())
                .orElseThrow( () -> new RuntimeException("user token with null."));
    }
}

package com.qianmua.util;

import com.qianmua.constant.AutoManageType;
import com.qianmua.constant.RandomChickenSoup;
import com.qianmua.pojo.User;
import com.qianmua.pojo.vo.AutoWriteDayInfo;
import com.qianmua.pojo.vo.AutoWriteWeekInfo;
import com.qianmua.pojo.vo.LoginVo;
import com.qianmua.pojo.vo.SinginVo;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/8  9:30
 * @description : 执行签到
 */
@Component
public class SigninUtil {

    /**
     * BASE API
     */
    private static final String uri = "https://api.moguding.net:9000";

    /**
     * sign with
     */
    public  synchronized void doSign(LoginVo login, final SinginVo singin) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss") ;
        String loginurl = uri + "/session/user/v1/login";

        System.out.println(dateFormat.format(new Date())+"   开始登录 登录信息为：" + login);
        NetworkApi.request(JsonUtils.serialize(login),
                loginurl,
                "",
                json -> {

            System.out.println(dateFormat.format(new Date())+"  登录成功：" + json);
            User parse = JsonUtils.parse(json, User.class);

            if (parse == null)
                return;

            String token = parse.getData().getToken();

            checkPlanId(singin);

            doAutoSign(singin, dateFormat, token);

            autoWrite(singin, token);

            // TODO mail通知

        });
    }


    /**
     * 自动日报，周报，月报
     * @param singin 信息实体
     * @param token token
     */
    private void autoWrite(SinginVo singin, String token) {
        String autoWriteUrl = uri + "/practice/paper/v1/save";

        // 日
        if (DateFormatUtils.isDayLast()){
            System.out.println(LocalDateTime.now() + " 日报:");
            doAutoWriteDay(singin, token, autoWriteUrl , AutoManageType.AUTO__WRITE_DAY);
        }else
            System.out.println(LocalDateTime.now() + " 日报条件不足");

        // 周
        if (DateFormatUtils.isThisWeekSaturday()){
            System.out.println(LocalDateTime.now() + " 周报：" );
            doAutoWriteWeek(singin , token , autoWriteUrl);
        }else
            System.out.println(LocalDateTime.now() + " 周报条件不足");


        // 月
        if (DateFormatUtils.isThisMonthLast()){
            System.out.println(LocalDateTime.now().getDayOfMonth() + " 月报: ");
            doAutoWriteDay(singin, token, autoWriteUrl , AutoManageType.AUTO__WRITE_MONTH);
        }else
            System.out.println(LocalDateTime.now() + " 月报条件不足");

    }

    /**
     * 自动日报
     */
    private void doAutoWriteDay(SinginVo singin, String token, String autoWriteUrl ,String type) {
        AutoWriteDayInfo info = new AutoWriteDayInfo();

        info.setAttachmentList(new ArrayList<>())
                .setAttachments("")
                .setContent(getRandomChickenSoup())
                .setPlanId(singin.getPlanId())
                .setReportType(type)
                .setTitle(AutoManageType.AUTO_TITLE);

        NetworkApi.request(JsonUtils.serialize(info), autoWriteUrl, token,
                json1 -> System.out.println( LocalDate.now() + " 自动月报写入 : "  + json1));
    }

    /**
     * 自动周报
     */
    private void doAutoWriteWeek(SinginVo singinVo , String token , String url){
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

        NetworkApi.request(JsonUtils.serialize(weekInfo), url, token,
                json1 -> System.out.println(LocalDate.now() +  " 自动周报写入 : "  + json1));

    }

    /**
     * 自动签到
     * @param singin 信息实体
     * @param dateFormat 日期格式
     * @param token token
     */
    private String doAutoSign(SinginVo singin, SimpleDateFormat dateFormat, String token) {
        String sign = uri + "/attendence/clock/v1/save";

        NetworkApi.request(JsonUtils.serialize(singin), sign, token,
                json1 -> System.out.println(dateFormat.format(new Date()) + "  签到成功：" + json1));

        return token;
    }

    private String getRandomChickenSoup(){
        int length = RandomChickenSoup.CHICKEN_SOUP.length;

        int random = new Random().nextInt(length);

        System.out.println(random);
        return RandomChickenSoup.CHICKEN_SOUP[random];

    }

    private void checkPlanId(SinginVo singin) {
        Objects.requireNonNull(singin.getPlanId());
    }
}

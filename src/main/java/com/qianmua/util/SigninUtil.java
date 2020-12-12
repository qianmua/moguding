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
import java.util.Random;

@Component
public class SigninUtil {
    /**
     * BASE API
     */
    private static final String uri = "https://api.moguding.net:9000";

    /**
     * sign with
     */
    public  synchronized void Sign(LoginVo login, final SinginVo singin) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss") ;
        String loginurl = uri + "/session/user/v1/login";

        // 一次连接
        System.out.println(dateFormat.format(new Date())+"   开始登录 登录信息为：" + login);
        NetworkApi.request(JsonUtils.serialize(login), loginurl, "", json -> {
            System.out.println(dateFormat.format(new Date())+"  登录成功：" + json);
            User parse = JsonUtils.parse(json, User.class);

            if (parse == null)
                return;
            // 取得token
            String token = parse.getData().getToken();
            // 自动签到
            autoSign(singin, dateFormat, token);
            // 自动填写周报日报月报
            AutoWrite(singin, token);

        });
    }

    /**
     * 自动日报，周报，月报
     * @param singin
     * @param token
     */
    private void AutoWrite(SinginVo singin, String token) {
        String autoWriteUrl = uri + "/practice/paper/v1/save";

        // 日
        if (DateFormatUtils.isDayLast()){
            System.out.println(LocalDateTime.now() + " 日报:");
            autoWriteDay(singin, token, autoWriteUrl , AutoManageType.AUTO__WRITE_DAY);
        }else
            System.out.println(LocalDateTime.now() + " 日报条件不足");

        // 周
        if (DateFormatUtils.isThisWeekSaturday()){
            System.out.println(LocalDateTime.now() + " 周报：" );
            autoWriteWeek(singin , token , uri);
        }else
            System.out.println(LocalDateTime.now() + " 周报条件不足");


        // 月
        if (DateFormatUtils.isThisMonthLast()){
            System.out.println(LocalDateTime.now().getDayOfMonth() + " 月报: ");
            autoWriteDay(singin, token, autoWriteUrl , AutoManageType.AUTO__WRITE_MONTH);
        }else
            System.out.println(LocalDateTime.now() + " 月报条件不足");

    }

    /**
     *         // 自动日报
     */
    private void autoWriteDay(SinginVo singin, String token, String autoWriteUrl ,String type) {
        AutoWriteDayInfo info = new AutoWriteDayInfo();
        info.setAttachmentList(new ArrayList<>())
                .setAttachments("")
                .setContent(getRandomChickenSoup())
                .setPlanId(singin.getPlanId())
                .setReportType(AutoManageType.AUTO__WRITE_DAY)
                .setTitle(AutoManageType.AUTO_TITLE);

        NetworkApi.request(JsonUtils.serialize(info), autoWriteUrl, token,
                json1 -> System.out.println( LocalDate.now() + " 自动日报写入 : "  + json1));
    }

    /**
     * 自动周报
     */
    private void autoWriteWeek(SinginVo singinVo , String token , String url){
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
     * @param singin
     * @param dateFormat
     * @param token
     * @return
     */
    private String autoSign(SinginVo singin, SimpleDateFormat dateFormat, String token) {
        String sign = uri + "/attendence/clock/v1/save";

        System.out.println("序列化参数 : " + JsonUtils.serialize(singin));
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
}

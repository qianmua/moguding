package com.qianmua.util;

import com.qianmua.constant.AutoManageType;
import com.qianmua.pojo.User;
import com.qianmua.pojo.vo.AutoWriteDayInfo;
import com.qianmua.pojo.vo.LoginVo;
import com.qianmua.pojo.vo.SinginVo;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Component
public class SigninUtil {
    /**
     * BASE API
     */
    private static final String uri = "https://api.moguding.net:9000";

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
            // 自动天入日报
            AutoWrite(singin, token);

        });
    }

    private void AutoWrite(SinginVo singin, String token) {
        // 自动日报
        String autoWriteUrl = uri + "/practice/paper/v1/save";
        AutoWriteDayInfo info = new AutoWriteDayInfo();

        info.setAttachmentList(new ArrayList<>())
                .setAttachments("")
                .setContent("有些话，适合藏在心里，有些痛苦，适合无声无息的忘记。当经历过，你成长了，自己知道就好。很多改变，不需要你自己说，别人会看得到。")
                .setPlanId(singin.getPlanId())
                .setReportType(AutoManageType.AUTO__WRITE_DAY)
                .setTitle(AutoManageType.AUTO_TITLE);
        NetworkApi.request(JsonUtils.serialize(info), autoWriteUrl, token,
                json1 -> System.out.println(" 自动周报写入 : "  + json1));

    }

    private String autoSign(SinginVo singin, SimpleDateFormat dateFormat, String token) {
        String sign = uri + "/attendence/clock/v1/save";

        System.out.println("序列化参数 : " + JsonUtils.serialize(singin));
        NetworkApi.request(JsonUtils.serialize(singin), sign, token,
                json1 -> System.out.println(dateFormat.format(new Date()) + "  签到成功：" + json1));
        return token;
    }
}

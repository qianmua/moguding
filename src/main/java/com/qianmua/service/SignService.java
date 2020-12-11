package com.qianmua.service;

import com.qianmua.constant.AutoManageType;
import com.qianmua.dao.LoginMapper;
import com.qianmua.pojo.Login;
import com.qianmua.pojo.PlanStu;
import com.qianmua.pojo.User;
import com.qianmua.pojo.vo.LoginVo;
import com.qianmua.pojo.vo.SinginVo;
import com.qianmua.util.JsonUtils;
import com.qianmua.util.NetworkApi;
import com.qianmua.util.SigninUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 宋LS
 * @version 1.0
 * @date 2020/9/6 16:31
 */
@Service
public class SignService {

    @Autowired
    private LoginMapper loginMapper;

    private static final String uri = "https://api.moguding.net:9000";

    /**
     * 签到
     * @return status
     */
    public String sign() throws InterruptedException {

        List<Login> logins = loginMapper.selectAll();
        for (Login login : logins) {

            LoginVo loginVo = new LoginVo();
            BeanUtils.copyProperties(login, loginVo);
            loginVo.setLoginType(login.getLogintype());

            SinginVo singinVo = new SinginVo();
            BeanUtils.copyProperties(login.getSingins(), singinVo);

            String plan = this.getPlan(loginVo);
            singinVo.setPlanId(plan);

            int i =  Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            singinVo.setType(i <= 12 ? AutoManageType.AUTO_START_MARK : AutoManageType.AUTO_END_MARK);

            new SigninUtil().Sign(loginVo, singinVo);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "SUCCESS";
    }

    /**
     *     // 得到PlanId
     *     login
     * @return ID
     */
    public String getPlan(LoginVo login) throws InterruptedException {

        final String[] plan = new String[1];
        String loginurl = uri + "/session/user/v1/login";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //String plan
        NetworkApi.request(JsonUtils.serialize(login), loginurl, "", json -> {
            String token;
            System.out.println(dateFormat.format(new Date()) + "  登录成功：" + json);
            User parse = JsonUtils.parse(json, User.class);

            if (parse != null)
                return;

            token = parse.getData().getToken();
            //获取任务id
            getPlan(plan, dateFormat, token);
        });
        Thread.sleep(5000);
        return plan[0];
    }


    /**
     * get
     * @param token
     */
    private void getPlan(String[] plan, SimpleDateFormat dateFormat, String token) {
        String planurl = uri + "/practice/plan/v1/getPlanByStu";
        NetworkApi.request("{\"state\":\"\"}", planurl, token, json1 -> {
            System.out.println(dateFormat.format(new Date()) + "  获取任务列表：" + json1);
            PlanStu planStu = JsonUtils.parse(json1, PlanStu.class);
            String planId = planStu.getData().get(0).getPlanId();
            plan[0] = planId;
            System.out.println("planId = " + planId);
        });
    }


}

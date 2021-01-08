package com.qianmua.service;

import com.qianmua.constant.AutoManageType;
import com.qianmua.dao.LoginMapper;
import com.qianmua.job.AutoRunningJob;
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
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 宋LS
 * @version 1.0
 * @date 2020/9/6 16:31
 * change by qianmu. date: 21/1/7
 */
@Service
public class SignService implements AutoRunningJob {

    @Autowired
    private LoginMapper loginMapper;

    private static final String uri = "https://api.moguding.net:9000";

    /**
     * 签到
     * 结构很乱
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

            // getPlantID
            String plan = this.getPlan(loginVo);
            singinVo.setPlanId(plan);

            int i =  Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

            // 签到状态转换
            singinVo.setType(i <= 12 ? AutoManageType.AUTO_START_MARK : AutoManageType.AUTO_END_MARK);

            // 签到
            new SigninUtil().doSign(loginVo, singinVo);

            try {
                TimeUnit.MILLISECONDS.sleep(20);
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

            if (parse == null)
                return;

            token = parse.getData().getToken();
            //获取任务id
            // 引用传递
            this.doGetPlan(plan, dateFormat, token);
        });

        TimeUnit.SECONDS.sleep(5);
        return plan[0];
    }

    /**
     * 自动执行调用接口
     */
    @Override
    public void autoJob(){
        System.out.println("===========================================================");
        System.out.println("执行时间: " + LocalDateTime.now());
        System.out.println("===========================================================");
        try {
            this.sign();
        } catch (InterruptedException e) {
            System.err.println("exception : " + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * get
     * @param token token
     */
    private void doGetPlan(String[] plan, SimpleDateFormat dateFormat, String token) {
        String planUrl = uri + "/practice/plan/v1/getPlanByStu";
        NetworkApi.request("{\"state\":\"\"}", planUrl, token, json1 -> {
//            System.out.println(dateFormat.format(new Date()) + "  获取任务列表：" + json1);
            PlanStu planStu = JsonUtils.parse(json1, PlanStu.class);
            // NPE 断言
            Objects.requireNonNull(planStu);

            String planId = planStu.getData().get(0).getPlanId();
            plan[0] = planId;
//            System.out.println("planId = " + planId);
        });

    }


}

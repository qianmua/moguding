package com.qianmua.sign.in;

import com.qianmua.constant.AutoManageType;
import com.qianmua.constant.SignStatusEnum;
import com.qianmua.job.AutoRunningJob;
import com.qianmua.pojo.Login;
import com.qianmua.pojo.PlanStu;
import com.qianmua.pojo.User;
import com.qianmua.pojo.vo.LoginVo;
import com.qianmua.pojo.vo.SinginVo;
import com.qianmua.service.UserService;
import com.qianmua.util.JsonUtils;
import com.qianmua.util.NetworkApi;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/10 17:43          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/10 17:43
 * @since JDK1.8
 */
@Service
@Slf4j
public class HandleSign implements AutoRunningJob {

    private final UserService userService;
    private final SignInServer signInServer;

    @Value("${mogu.service.sign-uri}")
    private String uri;

    public HandleSign(UserService userService, SignInServer signInServer) {
        this.userService = userService;
        this.signInServer = signInServer;
    }

    /**
     * 签到
     * @return status
     */
    public String sign() {
        List<Login> logins = userService.queryAllUserInfo();

        if (logins == null || logins.isEmpty()) {
            return SignStatusEnum.FAIL.getSymbol();
        }

        logins.forEach(lgs -> {
            LoginVo loginVo = getLoginVo(lgs);
            SinginVo singinVo = getSignVo(lgs, loginVo);
            // 线程安全
            signInServer.doSign(loginVo, singinVo);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return SignStatusEnum.SUCCESS.getSymbol();
    }

    /**
     *   得到PlanId
     * @return plan string
     */
    public String getPlan(LoginVo login) {

        final String[] plan = new String[1];
        String loginurl = uri + "/session/user/v1/login";

        //String plan
        NetworkApi.request(JsonUtils.serialize(login), loginurl, "", json -> {
            String token;
            User parse = JsonUtils.parse(json, User.class);
            Objects.requireNonNull(parse);
            token = parse.getData().getToken();
            this.doGetPlan(plan , token);
        });
        return Optional
                .ofNullable(plan[0])
                .orElse(null);
    }

    /**
     * 自动执行调用接口
     */
    @Override
    public void autoJob(){
        log.info("===========================================================");
        log.info("Execute Time: " + LocalDateTime.now());
        log.info("===========================================================");
        this.sign();
    }

    @NotNull
    private SinginVo getSignVo(Login login, LoginVo loginVo) {
        SinginVo singinVo = new SinginVo();
        BeanUtils.copyProperties(login.getSingins(), singinVo);
        String plan = getPlan(loginVo);
        if (plan == null){
            throw new RuntimeException("null plan id.");
        }
        singinVo.setPlanId(plan);

        singinVo.setType( Calendar.getInstance().get(Calendar.HOUR_OF_DAY) <= 12 ?
                AutoManageType.AUTO_START_MARK : AutoManageType.AUTO_END_MARK);
        return singinVo;
    }

    @NotNull
    private LoginVo getLoginVo(Login login) {
        LoginVo loginVo = new LoginVo();
        BeanUtils.copyProperties(login, loginVo);
        loginVo.setLoginType(login.getLogintype());
        return loginVo;
    }

    /**
     * 获取planId 可能返回空
     * @param token token
     */
    private void doGetPlan(String[] plan, String token) {

        String planUrl = uri + "/practice/plan/v1/getPlanByStu";
        NetworkApi.request("{\"state\":\"\"}", planUrl, token, json1 -> {
            PlanStu planStu = JsonUtils.parse(json1, PlanStu.class);
            Objects.requireNonNull(planStu);
            String planId = planStu.getData().get(0).getPlanId();
            plan[0] = planId;
        });

    }


}

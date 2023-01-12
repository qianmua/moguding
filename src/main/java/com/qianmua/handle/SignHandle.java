package com.qianmua.handle;

import com.qianmua.chain.AbstractAdapter;
import com.qianmua.constant.AutoManageType;
import com.qianmua.constant.SignStatusEnum;
import com.qianmua.framework.job.support.AutoJob;
import com.qianmua.entity.Login;
import com.qianmua.entity.PlanStu;
import com.qianmua.entity.User;
import com.qianmua.entity.vo.LoginVo;
import com.qianmua.entity.vo.SinginVo;
import com.qianmua.service.UserService;
import com.qianmua.util.JsonUtils;
import com.qianmua.util.LogUtils;
import com.qianmua.framework.support.NetworkApi;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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
public class SignHandle implements AutoJob {

    private final UserService userService;
    private final AbstractAdapter abstractAdapter;

    @Value("${mogu.service.sign-uri}")
    private String uri;

    public SignHandle(UserService userService, AbstractAdapter abstractAdapter) {
        this.userService = userService;
        this.abstractAdapter = abstractAdapter;
    }

    /**
     * 自动执行调用接口
     */
    @Override
    public void autoJob(){
        LogUtils.logEvent(log , "Trigger Event" , "Sign :" + LocalDateTime.now().toString());
        this.sign();
    }

    /**
     * 签到
     * @return status
     */
    public String sign() {
        LogUtils.logEvent(log , "1" , "queryAllUserInfo");
        List<Login> logins = userService.queryAllUserInfo();

        if (logins == null || logins.isEmpty()) {
            return SignStatusEnum.FAIL.getSymbol();
        }

        final String loginUrl = uri + "/session/user/v1/login";
        LogUtils.logEvent(log , "2" , "doSign");
        logins.forEach(lgs -> {

            LoginVo loginVo = getLoginVo(lgs);
            SinginVo singinVo = getSignVo(lgs, loginVo);
            // 线程安全
            LogUtils.logEvent(log , "call Login API" , loginVo.toString());
            NetworkApi.request(JsonUtils.serialize(loginVo),
                    loginUrl,
                    "",
                    // call back
                    json -> {
                        String token = checkToken(json);
                        Objects.requireNonNull(singinVo.getPlanId());
                        abstractAdapter.invokeAction(singinVo , token , code -> { } );
                    });
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

    private String checkToken(String json) {
        User parse = JsonUtils.parse(json, User.class);
        return Optional.ofNullable(parse)
                .map(var1 -> var1.getData().getToken())
                .orElseThrow( () -> new RuntimeException("user token with null."));
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

package com.qianmua.controller;

import com.qianmua.constant.AutoManageType;
import com.qianmua.constant.SignStatusEnum;
import com.qianmua.method.LoginMapper;
import com.qianmua.chain.handle.SignHandle;
import com.qianmua.framework.job.support.MorningJob;
import com.qianmua.framework.job.support.NightJob;
import com.qianmua.framework.job.config.SchedulerManager;
import com.qianmua.entity.Login;
import com.qianmua.entity.vo.LoginVo;
import com.qianmua.entity.vo.SinginVo;
import com.qianmua.service.UserService;
import com.qianmua.sign.in.SignInServer;
import org.quartz.SchedulerException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
@Deprecated
@Controller
@RequestMapping("/old/mogu")
public class MainController {

    public  final SchedulerManager  myScheduler;
    private final LoginMapper       loginMapper;
    private final SignInServer      signInServer;
    private final UserService       userservice;
    private final SignHandle        signHandle;

    public MainController(SchedulerManager myScheduler, LoginMapper loginMapper,
                          SignInServer signInServer, UserService userservice,
                          SignHandle signHandle) {

        this.myScheduler    = myScheduler;
        this.loginMapper    = loginMapper;
        this.signInServer   = signInServer;
        this.userservice    = userservice;
        this.signHandle     = signHandle;
    }

    @Deprecated
    @GetMapping(value = "/job/start")
    @ResponseBody
    public String scheduleJob2() {
        try {
            // //每五秒执行一次
            // 这里小心，会和数据库中的一起执行
            // 会额外产生签到和日志
            myScheduler.startJob("25 01 18 * * ?", AutoManageType.QUARTZ_JOB2, AutoManageType.QUARTZ_GROUP2, NightJob.class);
            myScheduler.startJob("25 51 8 * * ?", AutoManageType.QUARTZ_JOB1, AutoManageType.QUARTZ_GROUP1, MorningJob.class);

            // TODO 启动后发送邮件消息

            return "启动定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "启动定时器失败";
    }

    @Deprecated
    @GetMapping(value = "/job/end")
    @ResponseBody
    public String deleteScheduleJob2() {
        try {
            myScheduler.deleteJob(AutoManageType.QUARTZ_JOB2, AutoManageType.QUARTZ_GROUP2);

            // TODO 停止后发送邮件消息

            return "删除定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "删除定时器失败";
    }

    /**
     * get Page
     * @return index
     */
    @RequestMapping("index")
    public String index() {
        return "index.html";
    }

    /**
     * 定时任务执行失败时调用接口
     * @param ids 用户号（学号）
     * @return status
     */
    @GetMapping("/autoSign/list")
    public String autoSign(List<String> ids){
        // TODO 批量签到

        return SignStatusEnum.SUCCESS.toString();
    }

    /**
     * 手动签到接口
     * 签到, 日报 , 周报 , 月报
     */
    @Deprecated
    @ResponseBody
    @RequestMapping("autoSign")
    public String sign() {
        //signHandle.signReq();
        return "success";
    }


    /**
     * 添加用户
     * @param login 实参
     */
    @Deprecated
    @RequestMapping("/insert/member")
    @ResponseBody
    public String addMember(@RequestBody Login login) {
        Objects.requireNonNull(login);
        userservice.addUser(login);
        return "insert success.";
    }


    /**
    * ===========================================================
    *   下面方法准备进行重构
    * ===========================================================
    * */


    @Deprecated
    @RequestMapping("get")
    @ResponseBody
    public void get() {
        List<Login> logins = loginMapper.selectAll();

        for (Login login : logins) {
            LoginVo loginVo = new LoginVo();
            BeanUtils.copyProperties(login, loginVo);

            loginVo.setLoginType(login.getLogintype());
            SinginVo singinVo = new SinginVo();
            BeanUtils.copyProperties(login.getSingins(), singinVo);
            signInServer.doSign(loginVo, singinVo);

        }
    }

    @Deprecated
    @RequestMapping("add")
    @ResponseBody
    public String adduser(@RequestBody Login login) {
        userservice.addUser(login);
        return "添加成功";
    }

    @Deprecated
    @RequestMapping("planid")
    @ResponseBody
    public  String getPlanId(@RequestBody Login login) {
        LoginVo loginvo = new LoginVo();
        BeanUtils.copyProperties(login,loginvo);
        loginvo.setLoginType(login.getLogintype());
        return "";//signHandle.getPlan(loginvo);
    }

}
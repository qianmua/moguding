package com.qianmua.controller;

import com.qianmua.constant.AutoManageType;
import com.qianmua.dao.LoginMapper;
import com.qianmua.job.MyCronJob;
import com.qianmua.job.MyJob;
import com.qianmua.job.SchedulerManager;
import com.qianmua.pojo.Login;
import com.qianmua.pojo.vo.LoginVo;
import com.qianmua.pojo.vo.SinginVo;
import com.qianmua.sign.in.SignService;
import com.qianmua.service.Userservice;
import com.qianmua.sign.in.SignInServer;
import org.quartz.SchedulerException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mogu")
public class MainController {

    public final SchedulerManager myScheduler;
    private final LoginMapper loginMapper;
    private final SignInServer signInServer;
    private final Userservice userservice;
    private final SignService signService;

    public MainController(SchedulerManager myScheduler, LoginMapper loginMapper,
                          SignInServer signInServer, Userservice userservice,
                          SignService signService) {

        this.myScheduler = myScheduler;
        this.loginMapper = loginMapper;
        this.signInServer = signInServer;
        this.userservice = userservice;
        this.signService = signService;
    }

    @RequestMapping(value = "/job/start", method = RequestMethod.GET)
    @ResponseBody
    public String scheduleJob2() {
        //"20 10 8,17 * * ?"/
        try {
            // //每五秒执行一次
            // 这里小心，会和数据库中的一起执行
            // 会额外产生签到和日志
            myScheduler.startJob("25 01 18 * * ?", AutoManageType.QUARTZ_JOB2, AutoManageType.QUARTZ_GROUP2, MyCronJob.class);
            myScheduler.startJob("25 51 8 * * ?", AutoManageType.QUARTZ_JOB1, AutoManageType.QUARTZ_GROUP1, MyJob.class);

            // TODO 启动后发送邮件消息

            return "启动定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "启动定时器失败";
    }

    @RequestMapping(value = "/job/end", method = RequestMethod.GET)
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
     * 手动签到接口
     *
     * 自动签到
     *
     * 自动填写日报
     *
     * 周报
     *
     * 月报
     *
     */
    @ResponseBody
    @RequestMapping("autoSign")
    public String sign() throws InterruptedException {
        return signService.sign();
    }


    /**
     * 添加用户
     * @param login 实参
     */
    @RequestMapping("/insert/member")
    @ResponseBody
    public String addMember(@RequestBody Login login) {
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
    public String adduser(@RequestBody Login login) throws InterruptedException {
        userservice.addUser(login);
        return "添加成功";
    }

    @RequestMapping("planid")
    @Deprecated
    public  String getPlanId(@RequestBody Login login) throws InterruptedException {
        LoginVo loginvo = new LoginVo();
        BeanUtils.copyProperties(login,loginvo);
        loginvo.setLoginType(login.getLogintype());
        String plan = signService.getPlan(loginvo);
        return  plan;
    }

}
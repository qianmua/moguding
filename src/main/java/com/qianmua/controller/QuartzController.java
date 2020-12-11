package com.qianmua.controller;

import com.qianmua.constant.AutoManageType;
import com.qianmua.dao.LoginMapper;
import com.qianmua.job.MyCronJob;
import com.qianmua.job.MyJob;
import com.qianmua.job.SchedulerManager;
import com.qianmua.pojo.Login;
import com.qianmua.pojo.vo.LoginVo;
import com.qianmua.pojo.vo.SinginVo;
import com.qianmua.service.SignService;
import com.qianmua.service.Userservice;
import com.qianmua.util.SigninUtil;
import org.quartz.SchedulerException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Documented;
import java.util.List;

@Controller
@RequestMapping("/quartz")
public class QuartzController {
    @Autowired
    public SchedulerManager myScheduler;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private SigninUtil signinUtil;
    @Autowired
    private Userservice userservice;
    @Autowired
    private SignService signService;

    @RequestMapping(value = "/job2", method = RequestMethod.GET)
    @ResponseBody
    public String scheduleJob2() {
        //"20 10 8,17 * * ?"/
        try {

            // //每五秒执行一次
            myScheduler.startJob("25 01 18 * * ?", AutoManageType.QUARTZ_JOB2, AutoManageType.QUARTZ_GROUP2, MyCronJob.class);
            myScheduler.startJob("25 51 8 * * ?", AutoManageType.QUARTZ_JOB1, AutoManageType.QUARTZ_GROUP1, MyJob.class);

            return "启动定时器成功";

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "启动定时器失败";
    }

    @RequestMapping(value = "/del_job2", method = RequestMethod.GET)
    @ResponseBody
    public String deleteScheduleJob2() {
        try {
            myScheduler.deleteJob(AutoManageType.QUARTZ_JOB2, AutoManageType.QUARTZ_GROUP2);
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

    /*
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
            signinUtil.Sign(loginVo, singinVo);

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
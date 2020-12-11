package com.qianmua.job;

import com.qianmua.dao.LoginMapper;
import com.qianmua.pojo.Login;
import com.qianmua.pojo.vo.LoginVo;
import com.qianmua.pojo.vo.SinginVo;
import com.qianmua.service.SignService;
import com.qianmua.util.SigninUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Calendar;
import java.util.List;


public class MyJob extends QuartzJobBean {

    @Autowired
    private SignService signService;

    /**
     * 早班 签到
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            signService.sign();
        } catch (InterruptedException e) {
            System.err.println("定时任务异常：");
            e.printStackTrace();
        }
    }

}

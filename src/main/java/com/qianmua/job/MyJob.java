package com.qianmua.job;

import com.qianmua.service.SignService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;


public class MyJob extends QuartzJobBean {

    @Autowired
    private SignService signService;

    /**
     * 早班 签到
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        signService.autoJob();
    }

}

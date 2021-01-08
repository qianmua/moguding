package com.qianmua.job;

import com.qianmua.sign.in.SignServer;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class MyJob extends QuartzJobBean {

    @Autowired
    private SignServer signServer;

    /**
     * 早班 签到
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        signServer.autoJob();
    }

}

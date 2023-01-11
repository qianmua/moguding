package com.qianmua.job;


import com.qianmua.sign.in.HandleSign;
import org.jetbrains.annotations.NotNull;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyCronJob extends QuartzJobBean {

    @Autowired
    private HandleSign handleSign;

    /**
     * 晚班签到
     */
    @Override
    protected void executeInternal(@NotNull JobExecutionContext jobExecutionContext) throws JobExecutionException {
        handleSign.autoJob();
    }

}

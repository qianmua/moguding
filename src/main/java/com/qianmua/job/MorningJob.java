package com.qianmua.job;

import com.qianmua.chain.AbstractAdapter;
import com.qianmua.sign.in.HandleSign;
import org.jetbrains.annotations.NotNull;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MorningJob extends QuartzJobBean {

    @Autowired
    private HandleSign handleSign;

    @Autowired
    private AbstractAdapter abstractAdapter;

    /**
     * 早班 签到
     */
    @Override
    protected void executeInternal(@NotNull JobExecutionContext jobExecutionContext){
        handleSign.autoJob();
    }

}

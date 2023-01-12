package com.qianmua.framework.job.support;

import org.jetbrains.annotations.NotNull;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class MorningJob extends QuartzJobBean {

    @Autowired
    private List<AutoJob> autoJobList;

    /**
     * 签到调用接口
     */
    @Override
    protected void executeInternal(@NotNull JobExecutionContext jobExecutionContext){
        autoJobList.forEach(AutoJob::autoJob);
    }

}

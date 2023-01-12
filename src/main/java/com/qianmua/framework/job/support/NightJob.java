package com.qianmua.framework.job.support;


import org.jetbrains.annotations.NotNull;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class NightJob extends QuartzJobBean {

    @Autowired
    private List<AutoJob> autoJobList;

    /**
     * 晚班签到
     */
    @Override
    protected void executeInternal(@NotNull JobExecutionContext jobExecutionContext) throws JobExecutionException {
        autoJobList.forEach(AutoJob::autoJob);
    }

}

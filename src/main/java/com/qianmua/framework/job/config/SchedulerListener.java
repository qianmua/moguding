package com.qianmua.framework.job.config;

import com.qianmua.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

@Slf4j
public class SchedulerListener implements JobListener {

    public static final String LISTENER_NAME = "QuartSchedulerListener";

    @Override
    public String getName() {
        return LISTENER_NAME;
    }

    /**
     * 调度前
     * @param context job context
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().toString();
        LogUtils.logEvent(log , "Job Before" , jobName + " is going to start...");

    }

    /**
     * reject this job
     * @param context 当前上下文信息
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        LogUtils.logEvent(log , "Reject Job" , context.getJobDetail().toString());
    }

    /**
     * 调度后
     * @param context 上下文信息
     * @param jobException 任务信息为空("") 或者为null时抛出
     */
    @Override
    public void jobWasExecuted(JobExecutionContext context,
                               JobExecutionException jobException) {

        String jobName = context.getJobDetail().getKey().toString();
        LogUtils.logEvent(log , "Job After" , jobName + " is finished...");

        if (jobException != null && !jobException.getMessage().equals("")) {
            LogUtils.logEvent(log , "Job Exception" , jobName
                    + " Exception: " + jobException.getMessage());
        }
    }
}
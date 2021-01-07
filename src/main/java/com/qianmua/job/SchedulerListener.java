package com.qianmua.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class SchedulerListener implements JobListener {


    public static final String LISTENER_NAME = "QuartSchedulerListener";

    @Override
    public String getName() {
        return LISTENER_NAME; //must return a name
    }

    /**
     * 调度前
     * @param context
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().toString();
        System.out.println("Job listen before: " + jobName + " is going to start...");

    }

    /**
     * reject this job
     * @param context 当前上下文信息
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("任务被拒绝");
        // to log
        // 因为在linux做了输出重定向 这里可以直接输出


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
        System.out.println("Job after : " + jobName + " is finished...");

        if (jobException != null && !jobException.getMessage().equals("")) {
            System.out.println("Exception thrown by: " + jobName
                    + " Exception: " + jobException.getMessage());
        }
    }
}
package com.qianmua.job;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class SchedulerManager {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    private JobListener scheduleListener;

    /**
     * 开始定时任务
     *
     * @param jobName jobName
     * @param jobGroup jobGroup
     * @throws SchedulerException e
     */
    public void startJob(String cron, String jobName, String jobGroup,
                         Class<? extends Job> jobClass)
            throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        if (scheduleListener == null) {
            scheduleListener = new SchedulerListener();
            scheduler.getListenerManager().addJobListener(scheduleListener);
        }
        JobKey jobKey = new JobKey(jobName, jobGroup);
        if (!scheduler.checkExists(jobKey)) {
            scheduleJob(cron, scheduler, jobName, jobGroup, jobClass);
        }
    }

    /**
     * 移除定时任务
     */
    public void deleteJob(String jobName, String jobGroup)
            throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = new JobKey(jobName, jobGroup);
        scheduler.deleteJob(jobKey);
    }

    /**
     * 暂停定时任务
     */
    public void pauseJob(String jobName, String jobGroup)
            throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = new JobKey(jobName, jobGroup);
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复定时任务
     */
    public void resumeJob(String jobName, String jobGroup)
            throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey triggerKey = new JobKey(jobName, jobGroup);
        scheduler.resumeJob(triggerKey);
    }

    /**
     * 清空所有当前scheduler对象下的定时任务【目前只有全局一个scheduler对象】
     */
    public void clearAll()
            throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.clear();
    }

    /**
     * 动态创建Job
     * 此处的任务可以配置可以放到properties或者是放到数据库中
     * Trigger:name和group 目前和job的name、group一致，之后可以扩展归类
     *
     * @param scheduler scheduler
     */
    private void scheduleJob(String cron, Scheduler scheduler, String jobName, String jobGroup,
                             Class<? extends Job> jobClass)
            throws SchedulerException {
        /*
         *  此处可以先通过任务名查询数据库，如果数据库中存在该任务，更新任务的配置以及触发器
         *  如果此时数据库中没有查询到该任务，则按照下面的步骤新建一个任务，并配置初始化的参数，并将配置存到数据库中
         */
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();
        // 每5s执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(jobName,
                jobGroup).withSchedule(scheduleBuilder).build();

        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
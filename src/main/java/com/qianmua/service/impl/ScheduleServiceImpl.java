package com.qianmua.service.impl;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.qianmua.common.errorcode.BaseErrorCodeEnum;
import com.qianmua.constant.AutoManageType;
import com.qianmua.framework.job.config.JobModelEnum;
import com.qianmua.framework.job.config.SchedulerManager;
import com.qianmua.framework.support.Assert;
import com.qianmua.service.ScheduleService;
import com.qianmua.util.LogUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * description：
 * <p>
 * </p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------<p>
 * 2023/7/27 15:50          ********    kong.ruo    create file.
 *
 * @author kong.ruo
 * @date 2023/7/27 15:50
 * @since JDK1.8
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final SchedulerManager schedulerManager;
    @Override
    public void startAllRegisterJob(String jobGroup) {
        // step - get job model cron config
        Optional.ofNullable(this.getJobByGroup(jobGroup))
                .ifPresent(aJobInfoList -> aJobInfoList.forEach(aJobInfo -> {
                    // step get job cron info
                    JobModelEnum jobModelEnum = JobModelEnum.match(aJobInfo , jobGroup);
                    Assert.check(Objects.isNull(jobModelEnum) , BaseErrorCodeEnum.SYSTEM_ERROR , "Job Model Enum");
                    try {
                        String JobCron = jobModelEnum.getCron();
                        String jobMode = jobModelEnum.getModel();
                        Class<? extends QuartzJobBean> jobActuator = jobModelEnum.getJobActuator();

                        // step - start
                        LogUtils.logStrut(log , "Job Model" , aJobInfo);
                        LogUtils.logStrut(log , "Job Group" , jobGroup);
                        schedulerManager.startJob(JobCron, jobMode, jobGroup, jobActuator);
                    } catch (Exception e) {
                        LogUtils.logError(log , "Job Start Error" , e.getMessage());
                        e.printStackTrace();
                    }
                }));
    }

    @Override
    public void endAllRunTimeJob(String jobGroup) {
        // step - end by group or job
        List<String> jobList = this.getJobByGroup(jobGroup);
        Optional.ofNullable(jobList)
                .ifPresent(aJobList -> aJobList.forEach(aJobInfo -> {
                    try {
                        // step - end by model
                        LogUtils.logStrut(log , "Job Model" , aJobInfo);
                        LogUtils.logStrut(log , "Job Group" , jobGroup);
                        schedulerManager.deleteJob(aJobInfo, jobGroup);
                    } catch (Exception e) {
                        LogUtils.logError(log , "Job End Error" , e.getMessage());
                        e.printStackTrace();
                    }
                }));
    }

    private List<String> getJobByGroup(String jobGroupSign) {
        if (StrUtil.isNotEmpty(jobGroupSign)) {
            return Lists.newArrayList(AutoManageType.JOB_EIGHT_AM, AutoManageType.JOB_SIX_PM);
        }
        return null;
    }


}

package com.qianmua.framework.job.config;

import cn.hutool.core.util.StrUtil;
import com.qianmua.common.errorcode.BaseErrorCodeEnum;
import com.qianmua.constant.AutoManageType;
import com.qianmua.framework.job.support.MorningJob;
import com.qianmua.framework.job.support.NightJob;
import com.qianmua.framework.support.Assert;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * description：
 * <p>
 * </p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------<p>
 * 2023/7/27 16:27          ********    kong.ruo    create file.
 *
 * @author kong.ruo
 * @date 2023/7/27 16:27
 * @since JDK1.8
 */
public enum JobModelEnum {
    MORNING(AutoManageType.JOB_EIGHT_AM , AutoManageType.JOB_GROUP_SIGN , "25 51 8 * * ?" , MorningJob.class),
    NIGHT(AutoManageType.JOB_SIX_PM , AutoManageType.JOB_GROUP_SIGN , "25 01 18 * * ?" , NightJob.class),

    ;

    private final String model;

    private final String jobGroup;

    private final String cron;

    private final Class<? extends QuartzJobBean> jobActuator;

    JobModelEnum(String model, String jobGroup,  String cron, Class<? extends QuartzJobBean> jobActuator) {
        this.model = model;
        this.jobGroup = jobGroup;
        this.jobActuator = jobActuator;
        this.cron = cron;
    }

    public String getModel() {
        return model;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public Class<? extends QuartzJobBean> getJobActuator() {
        return jobActuator;
    }

    public String getCron() {
        return cron;
    }

    /**
     * description：
     * <p>
     *     get job model enum by job model str and job group str
     * </p>
     * change history:
     * date                         defect#        person       comments
     * -----------------------------------------------------------------<p>
     * 2023-07-27                    ********       kong.ruo    create file.
     *
     * @author kong.ruo
     * @date 2023-07-27 17:41
     * @param    jobModel jobModel str
     * @param    jobGroup jobGroup str
     * @return {@link JobModelEnum}
     * @since JDK1.8
     */
    public static JobModelEnum match(String jobModel , String jobGroup) {
        Assert.check(StrUtil.isEmpty(jobModel) || StrUtil.isEmpty(jobGroup) , BaseErrorCodeEnum.SYSTEM_ERROR);
        for (JobModelEnum value : values()) {
            // jobModel && jobGroup eq
            if (StrUtil.equals(value.getModel() , jobModel) && StrUtil.equals(value.getJobGroup() , jobModel)) {
                return value;
            }
        }
        return null;
    }
}

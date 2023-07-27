package com.qianmua.constant;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/11  14:18
 * @description :
 */
public interface AutoManageType {

    //title
    String AUTO_TITLE = "工作";

    String AUTO__WRITE_DAY = "day";
    String AUTO__WRITE_WEEK = "week";
    String AUTO__WRITE_MONTH = "month";


    // start end type with sign
    String AUTO_START_MARK = "START";
    String AUTO_END_MARK = "END";

    // quartz job
    String QUARTZ_JOB1 = "job1";
    String QUARTZ_JOB2 = "job2";

    /**
     * 上午八点定时扫描
     */
    String JOB_EIGHT_AM = "Job_Eight.AM";

    /**
     * 下午六点定时扫描
     */
    String JOB_SIX_PM = "Job_Six.PM";

    String JOB_GROUP_SIGN = "SignJobGroup";
    // quartz group
    String QUARTZ_GROUP1 = "group1";
    String QUARTZ_GROUP2 = "group2";

    // base week
    String BASE_WEEK = "2020-11-30";

    // base month
    String BASE_MONTH = "2020-12";

    // 周六 打周报
     String WRITE_WEEK_ = "SATURDAY";

    // 每月28号 打月报
    String WRITE_MONTH_28 = "";

}

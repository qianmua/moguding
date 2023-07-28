package com.qianmua.service;

import com.qianmua.entity.input.CreateJobIn;

/**
 * description：
 * <p>
 * </p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------<p>
 * 2023/7/27 15:49          ********    ruo kong    create file.
 *
 * @author ruo kong
 * @date 2023/7/27 15:49
 * @since JDK1.8
 */
public interface ScheduleService {
    /**
     * description：
     * <p>
     *     检查所有已经注册的Job 并启动监听
     *     如果有正在运行的Job，重新启动
     * </p>
     * change history:
     * date                         defect#        person       comments
     * -----------------------------------------------------------------<p>
     * 2023-07-27                    ********       ruo kong    create file.
     *
     * @author ruo kong
     * @date 2023-07-27 16:54
     */
    void startAllRegisterJob(String jobGroup);

    /**
     * description：
     * <p>
     *     结束全部正在运行的Job
     * </p>
     * change history:
     * date                         defect#        person       comments
     * -----------------------------------------------------------------<p>
     * 2023-07-27                    ********       ruo kong    create file.
     *
     * @author ruo kong
     * @date 2023-07-27 16:02
     */
    void endAllRunTimeJob(String jobGroup);

    /**
     * description：
     * <p>
     *     创建新的Job Trigger
     * </p>
     * change history:
     * date                         defect#        person       comments
     * -----------------------------------------------------------------<p>
     * 2023-07-28                    ********       kong.ruo    create file.
     *
     * @author ruo kong
     * @date 2023-07-28 10:14
     * @param	createJobIn	jobInParams
     * @since JDK1.8
     */
    void createJob(CreateJobIn createJobIn);

}

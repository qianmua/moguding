package com.qianmua.controller;

import com.qianmua.constant.AutoManageType;
import com.qianmua.framework.support.JsonWrapper;
import com.qianmua.service.ScheduleService;
import com.qianmua.util.LogUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 15:05          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 15:05
 * @since JDK1.8
 */
@RestController
@RequestMapping("/mogu/job")
@Slf4j
@RequiredArgsConstructor
public class ScheduleResource {

    private final ScheduleService scheduleService;

    @GetMapping("/start")
    public JsonWrapper startJob() {
        LogUtils.logInfo(log,  "Start Reg Job");
        scheduleService.startAllRegisterJob(AutoManageType.JOB_GROUP_SIGN);
        LogUtils.logInfo(log , "Job Start End.");
        return JsonWrapper.respSuccess();
    }

    @GetMapping("/end")
    public JsonWrapper endJob() {
        LogUtils.logInfo(log,  "End All Job");
        scheduleService.endAllRunTimeJob(AutoManageType.JOB_GROUP_SIGN);
        LogUtils.logInfo(log , "End Job Succ.");
        return JsonWrapper.respSuccess();
    }

}

package com.qianmua.controller;

import com.qianmua.framework.support.JsonWrapper;
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
public class ScheduleResource {



    @GetMapping("/auto/start")
    public JsonWrapper startJob() {

        return JsonWrapper.respSuccess();
    }

    @GetMapping("/auto/end")
    public JsonWrapper endJob() {

        return JsonWrapper.respSuccess();
    }
}

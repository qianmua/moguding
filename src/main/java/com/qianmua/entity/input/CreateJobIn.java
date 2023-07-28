package com.qianmua.entity.input;

import lombok.Data;

/**
 * description：
 * <p>
 * </p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------<p>
 * 2023/7/28 10:02          ********    kong.ruo    create file.
 *
 * @author ruo kong
 * @date 2023/7/28 10:02
 * @since JDK1.8
 */
@Data
public class CreateJobIn {

    private String clustered;

    private String triggerID;

    private String triggerGroup;

    private String jobID;

    private String jobGroupID;

    private String description;

    private Long nextFireTime;

    private Long prevFireTime;

    private Integer priority;

    private String TriggerState;

    private String triggerType;

    private String startTime;

    private String endTime;

    private String calendarName;

    private String misfireInstr;

    private String jobData;

}

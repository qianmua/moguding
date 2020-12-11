package com.qianmua.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/11  13:50
 * @description :
 */
@Data
@Accessors( chain = true)
public class AutoWriteDayInfo {

    /*
    attachmentList: []
    attachments: ""
    content: "有些话，适合藏在心里，有些痛苦，适合无声无息的忘记。当经历过，你成长了，自己知道就好。很多改变，不需要你自己说，别人会看得到。"
    planId: "92df4e75f559cce3f8404f2d5d71b63c"
    reportType: "day"
    title: "工作"
     */
    /*
    attachmentList: []
    attachments: ""
    content: "也许你听过一首歌，歌词是“不抛弃，不放弃”;也许你攻克难题时，老师会对你说：“快解出来了，不要放弃”;也许在长跑时，你会对自己说：“坚持一下就到终点了，不能放弃”。但是，我要告诉你，学会放弃。加油啊！！！"
    endTime: "2020-12-13 23:59:59"
    planId: "92df4e75f559cce3f8404f2d5d71b63c"
    reportType: "week"
    startTime: "2020-12-07 00:00:00"
    title: "第1周周记"
    weeks: "第1周"

     */

    /*

    attachmentList: []
    attachments: ""
    content: "没有狂风和暴雨的吹打，哪来果实的的成熟;没有刺骨的寒风，哪来坚韧的松柏;没有冰天雪地;哪来傲骨的梅花。彼得逊说过：“人生中，经常有无数来自外部的打击，但这些打击究竟会对你产生怎样的影响，最终的决定权在你自己手中。”"
    planId: "92df4e75f559cce3f8404f2d5d71b63c"
    reportType: "month"
    title: "工作"

     */

    private List<String> attachmentList;
    private String attachments;
    private String content;
    private String planId;
    // day 报告 - -！
    // day
    // week
    // month
    private String reportType;
    private String title;
}

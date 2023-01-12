package com.qianmua.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class PlanStu {

    /**
     * code : 200
     * msg : success
     * data : [{"totalCount":0,"pageSize":10,"totalPage":0,"currPage":1,"isDeleted":null,"createBy":null,"modifiedBy":null,"createTime":null,"modifiedTime":null,"createByName":null,"modifiedByName":null,"orderBy":"create_time","sort":"desc","planId":"258dee62efac54ff2d8c1987c3c2ac77","schoolId":null,"depId":null,"depName":null,"planName":"系统默认计划","planNumber":null,"planLevel":null,"planGrades":null,"type":"D_PRACTICE","startTime":"1970-01-01 00:00:00","endTime":"2099-01-01 23:59:59","subsidy":null,"description":null,"planState":null,"backup":null,"isSign":0,"isAuto":"0","batchId":null,"practiceStus":null,"snowFlakeId":null,"batchName":"系统默认批次","planPaper":{"isDeleted":0,"createTime":"2019-09-05 17:44:15","planPaperId":"d889170f0d2953e73b4d3b2a4be573f6","planId":"258dee62efac54ff2d8c1987c3c2ac77","dayPaperNum":0,"weekPaperNum":0,"monthPaperNum":0,"summaryPaperNum":0,"weekReportCount":0,"paperReportCount":0,"monthReportCount":0,"summaryReportCount":0,"maxDayNum":8000,"maxWeekNum":8000,"maxMonthNum":8000,"maxSummaryNum":10000,"snowFlakeId":1000004,"dayPaper":false,"weekPaper":false,"monthPaper":false,"summaryPaper":false},"planPaperMap":null,"attachments":null,"planMajors":null,"planClasses":null,"planAppraiseItem":null,"planAppraiseItemDtos":null,"planAppraiseItemEntities":null,"majorNames":null,"createName":"","attachmentNum":1,"planIds":null,"signCount":null,"auditState":null,"majorTeacher":null,"majorId":null,"majorName":null,"majorField":null,"semester":null,"planExtra":null,"majorTeacherId":null,"isSysDefault":1,"teacherName":null,"isCopyAllocate":null,"isCopy":null,"isShowUpDel":null,"isBuyInsurance":null,"stuItemIds":null,"selfMultiple":null,"schoolTeacher":null,"companyMultiple":null,"multipleTheory":null}]
     */

    public int code;
    public String msg;
    public List<DataBean> data;

    @NoArgsConstructor
    @Data
    public static class DataBean {
        /**
         * totalCount : 0
         * pageSize : 10
         * totalPage : 0
         * currPage : 1
         * isDeleted : null
         * createBy : null
         * modifiedBy : null
         * createTime : null
         * modifiedTime : null
         * createByName : null
         * modifiedByName : null
         * orderBy : create_time
         * sort : desc
         * planId : 258dee62efac54ff2d8c1987c3c2ac77
         * schoolId : null
         * depId : null
         * depName : null
         * planName : 系统默认计划
         * planNumber : null
         * planLevel : null
         * planGrades : null
         * type : D_PRACTICE
         * startTime : 1970-01-01 00:00:00
         * endTime : 2099-01-01 23:59:59
         * subsidy : null
         * description : null
         * planState : null
         * backup : null
         * isSign : 0
         * isAuto : 0
         * batchId : null
         * practiceStus : null
         * snowFlakeId : null
         * batchName : 系统默认批次
         * planPaper : {"isDeleted":0,"createTime":"2019-09-05 17:44:15","planPaperId":"d889170f0d2953e73b4d3b2a4be573f6","planId":"258dee62efac54ff2d8c1987c3c2ac77","dayPaperNum":0,"weekPaperNum":0,"monthPaperNum":0,"summaryPaperNum":0,"weekReportCount":0,"paperReportCount":0,"monthReportCount":0,"summaryReportCount":0,"maxDayNum":8000,"maxWeekNum":8000,"maxMonthNum":8000,"maxSummaryNum":10000,"snowFlakeId":1000004,"dayPaper":false,"weekPaper":false,"monthPaper":false,"summaryPaper":false}
         * planPaperMap : null
         * attachments : null
         * planMajors : null
         * planClasses : null
         * planAppraiseItem : null
         * planAppraiseItemDtos : null
         * planAppraiseItemEntities : null
         * majorNames : null
         * createName :
         * attachmentNum : 1
         * planIds : null
         * signCount : null
         * auditState : null
         * majorTeacher : null
         * majorId : null
         * majorName : null
         * majorField : null
         * semester : null
         * planExtra : null
         * majorTeacherId : null
         * isSysDefault : 1
         * teacherName : null
         * isCopyAllocate : null
         * isCopy : null
         * isShowUpDel : null
         * isBuyInsurance : null
         * stuItemIds : null
         * selfMultiple : null
         * schoolTeacher : null
         * companyMultiple : null
         * multipleTheory : null
         */

        public int totalCount;
        public int pageSize;
        public int totalPage;
        public int currPage;
        public Object isDeleted;
        public Object createBy;
        public Object modifiedBy;
        public Object createTime;
        public Object modifiedTime;
        public Object createByName;
        public Object modifiedByName;
        public String orderBy;
        public String sort;
        public String planId;
        public Object schoolId;
        public Object depId;
        public Object depName;
        public String planName;
        public Object planNumber;
        public Object planLevel;
        public Object planGrades;
        public String type;
        public String startTime;
        public String endTime;
        public Object subsidy;
        public Object description;
        public Object planState;
        public Object backup;
        public int isSign;
        public String isAuto;
        public Object batchId;
        public Object practiceStus;
        public Object snowFlakeId;
        public String batchName;
        public PlanPaperBean planPaper;
        public Object planPaperMap;
        public Object attachments;
        public Object planMajors;
        public Object planClasses;
        public Object planAppraiseItem;
        public Object planAppraiseItemDtos;
        public Object planAppraiseItemEntities;
        public Object majorNames;
        public String createName;
        public int attachmentNum;
        public Object planIds;
        public Object signCount;
        public Object auditState;
        public Object majorTeacher;
        public Object majorId;
        public Object majorName;
        public Object majorField;
        public Object semester;
        public Object planExtra;
        public Object majorTeacherId;
        public int isSysDefault;
        public Object teacherName;
        public Object isCopyAllocate;
        public Object isCopy;
        public Object isShowUpDel;
        public Object isBuyInsurance;
        public Object stuItemIds;
        public Object selfMultiple;
        public Object schoolTeacher;
        public Object companyMultiple;
        public Object multipleTheory;

        @NoArgsConstructor
        @Data
        public static class PlanPaperBean {
            /**
             * isDeleted : 0
             * createTime : 2019-09-05 17:44:15
             * planPaperId : d889170f0d2953e73b4d3b2a4be573f6
             * planId : 258dee62efac54ff2d8c1987c3c2ac77
             * dayPaperNum : 0
             * weekPaperNum : 0
             * monthPaperNum : 0
             * summaryPaperNum : 0
             * weekReportCount : 0
             * paperReportCount : 0
             * monthReportCount : 0
             * summaryReportCount : 0
             * maxDayNum : 8000
             * maxWeekNum : 8000
             * maxMonthNum : 8000
             * maxSummaryNum : 10000
             * snowFlakeId : 1000004
             * dayPaper : false
             * weekPaper : false
             * monthPaper : false
             * summaryPaper : false
             */

            public int isDeleted;
            public String createTime;
            public String planPaperId;
            public String planId;
            public int dayPaperNum;
            public int weekPaperNum;
            public int monthPaperNum;
            public int summaryPaperNum;
            public int weekReportCount;
            public int paperReportCount;
            public int monthReportCount;
            public int summaryReportCount;
            public int maxDayNum;
            public int maxWeekNum;
            public int maxMonthNum;
            public int maxSummaryNum;
            public int snowFlakeId;
            public boolean dayPaper;
            public boolean weekPaper;
            public boolean monthPaper;
            public boolean summaryPaper;
        }
    }
}

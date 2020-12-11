package com.qianmua.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@NoArgsConstructor
@Data
public class User {

    /**
     * code : 200
     * msg : success
     * data : {"userId":"101435721","phone":"18788965891","moguNo":"3305078","nikeName":"白尚林","gender":1,"userType":"student","token":"eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJtb2d1ZGluZy11c2VyIiwic3ViIjoie1wibG9naW5UeXBlXCI6XCJhbmRyb2lkXCIsXCJ1c2VySWRcIjoxMDE0MzU3MjF9IiwiYXVkIjoibW9ndWRpbmciLCJleHAiOjE5MDA5MTg4ODYsIm5iZiI6MTU4NTI5ODc4NiwiaWF0IjoxNTg1Mjk5Njg2fQ.0JvocfawpXDf-JfpDnI8x2Dt-wyYAXMJjARlI3yvhLccsoV3XQurhVQB6TUmncYi_Q3cZsM9gjOkUBBrxanBVw","expiredTime":1900918886000,"headImg":"f005585371b08470a447374c1a8e85c7.png","plan":null,"orgJson":{"companyId":null,"companyName":null,"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorName":"移动应用开发","majorField":null,"className":"Z移动1704","studentId":"932330bf368289d957175d518d61678e","teacheId":null,"userName":"白尚林","snowFlakeId":"1000004","studentNumber":"201761021203082","teacherNumber":null,"grade":"2017","post":null},"roleGroup":[{"totalCount":0,"pageSize":10,"totalPage":0,"currPage":1,"isDeleted":null,"createBy":null,"modifiedBy":null,"createTime":null,"modifiedTime":null,"createByName":null,"modifiedByName":null,"orderBy":"create_time","sort":"desc","roleUserId":null,"roleId":"1123121137695158273","userId":null,"backup":null,"roleName":"学生","roleKey":"student","state":null,"roleLevel":null}],"roleName":"学生","roleId":"1123121137695158273","roleLevel":null,"roleKey":"student","dataList":null,"neteaseImId":null,"umengId":null,"authType":0,"sessionKey":null,"isAccount":0}
     */

    private int code;
    private String msg;
    private DataBean data;

    @NoArgsConstructor
    @Data
    public static class DataBean {
        /**
         * userId : 101435721
         * phone : 18788965891
         * moguNo : 3305078
         * nikeName : 白尚林
         * gender : 1
         * userType : student
         * token : eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJtb2d1ZGluZy11c2VyIiwic3ViIjoie1wibG9naW5UeXBlXCI6XCJhbmRyb2lkXCIsXCJ1c2VySWRcIjoxMDE0MzU3MjF9IiwiYXVkIjoibW9ndWRpbmciLCJleHAiOjE5MDA5MTg4ODYsIm5iZiI6MTU4NTI5ODc4NiwiaWF0IjoxNTg1Mjk5Njg2fQ.0JvocfawpXDf-JfpDnI8x2Dt-wyYAXMJjARlI3yvhLccsoV3XQurhVQB6TUmncYi_Q3cZsM9gjOkUBBrxanBVw
         * expiredTime : 1900918886000
         * headImg : f005585371b08470a447374c1a8e85c7.png
         * plan : null
         * orgJson : {"companyId":null,"companyName":null,"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorName":"移动应用开发","majorField":null,"className":"Z移动1704","studentId":"932330bf368289d957175d518d61678e","teacheId":null,"userName":"白尚林","snowFlakeId":"1000004","studentNumber":"201761021203082","teacherNumber":null,"grade":"2017","post":null}
         * roleGroup : [{"totalCount":0,"pageSize":10,"totalPage":0,"currPage":1,"isDeleted":null,"createBy":null,"modifiedBy":null,"createTime":null,"modifiedTime":null,"createByName":null,"modifiedByName":null,"orderBy":"create_time","sort":"desc","roleUserId":null,"roleId":"1123121137695158273","userId":null,"backup":null,"roleName":"学生","roleKey":"student","state":null,"roleLevel":null}]
         * roleName : 学生
         * roleId : 1123121137695158273
         * roleLevel : null
         * roleKey : student
         * dataList : null
         * neteaseImId : null
         * umengId : null
         * authType : 0
         * sessionKey : null
         * isAccount : 0
         */

        private String userId;
        private String phone;
        private String moguNo;
        private String nikeName;
        private int gender;
        private String userType;
        private String token;
        private long expiredTime;
        private String headImg;
        private Object plan;
        private OrgJsonBean orgJson;
        private String roleName;
        private String roleId;
        private Object roleLevel;
        private String roleKey;
        private Object dataList;
        private Object neteaseImId;
        private Object umengId;
        private int authType;
        private Object sessionKey;
        private int isAccount;
        private List<RoleGroupBean> roleGroup;

        @NoArgsConstructor
        @Data
        public static class OrgJsonBean {
            /**
             * companyId : null
             * companyName : null
             * schoolId : 2e1574e92516c58ef5ae386b131f0bf9
             * schoolName : 成都工业职业技术学院
             * depName : 信息工程学院
             * depId : 0d1561ca0c221779c9aad564cfe42e37
             * majorId : 404e33e181e941dc98de9a25e5dfb525
             * classId : c9580ce87c0e8c41838ef4308ffb8ee5
             * majorName : 移动应用开发
             * majorField : null
             * className : Z移动1704
             * studentId : 932330bf368289d957175d518d61678e
             * teacheId : null
             * userName : 白尚林
             * snowFlakeId : 1000004
             * studentNumber : 201761021203082
             * teacherNumber : null
             * grade : 2017
             * post : null
             */

            private Object companyId;
            private Object companyName;
            private String schoolId;
            private String schoolName;
            private String depName;
            private String depId;
            private String majorId;
            private String classId;
            private String majorName;
            private Object majorField;
            private String className;
            private String studentId;
            private Object teacheId;
            private String userName;
            private String snowFlakeId;
            private String studentNumber;
            private Object teacherNumber;
            private String grade;
            private Object post;
        }

        @NoArgsConstructor
        @Data
        public static class RoleGroupBean {
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
             * roleUserId : null
             * roleId : 1123121137695158273
             * userId : null
             * backup : null
             * roleName : 学生
             * roleKey : student
             * state : null
             * roleLevel : null
             */

            private int totalCount;
            private int pageSize;
            private int totalPage;
            private int currPage;
            private Object isDeleted;
            private Object createBy;
            private Object modifiedBy;
            private Object createTime;
            private Object modifiedTime;
            private Object createByName;
            private Object modifiedByName;
            private String orderBy;
            private String sort;
            private Object roleUserId;
            private String roleId;
            private Object userId;
            private Object backup;
            private String roleName;
            private String roleKey;
            private Object state;
            private Object roleLevel;
        }
    }
}

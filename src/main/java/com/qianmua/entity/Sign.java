package com.qianmua.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Sign {

    /**
     * code : 200
     * msg : success
     * data : [{"attendanceId":"beb4f473f8bc4e4e97120d697f2a2888","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349764","latitude":"28.104204","country":"中国","province":"四川省","city":"泸州市","address":"四川省 · 泸州市 · 江村","device":"Android","createTime":"2020-02-14 15:38:00","modifiedTime":"2020-02-14 15:38:00","isDeleted":0,"type":"END","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":"","attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-14","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-14 15:38:00","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581665880444,"attendanceTypeNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1},{"attendanceId":"fec618e8bf4942869a244d81a30632e8","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349764","latitude":"28.104204","country":"中国","province":"四川省","city":"泸州市","address":"四川省 · 泸州市 · 江村","device":"Android","createTime":"2020-02-14 15:38:00","modifiedTime":"2020-02-14 15:38:00","isDeleted":0,"type":"END","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":"","attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-14","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-14 15:38:00","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581665880386,"attendanceTypeNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1},{"attendanceId":"eb6fef350f2645db86b38484bafdd381","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349514","latitude":"28.104136","country":null,"province":null,"city":null,"address":"四川省 · 泸州市 · 江村","device":"iOS","createTime":"2020-02-14 08:14:07","modifiedTime":"2020-02-14 08:14:07","isDeleted":0,"type":"START","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":null,"attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-14","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-14 08:14:07","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581639247061,"attendanceTypeNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1},{"attendanceId":"3f29103b7c4443a38e2962d91250dfab","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349772","latitude":"28.104204","country":"中国","province":"四川省","city":"泸州市","address":"四川省 · 泸州市 · 江村","device":"Android","createTime":"2020-02-13 18:49:45","modifiedTime":"2020-02-13 18:49:45","isDeleted":0,"type":"END","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":"","attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-13","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-13 18:49:45","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581590985122,"attendanceTypeNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1},{"attendanceId":"3c088d77203e42a784d465f034ceff64","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349772","latitude":"28.104204","country":"中国","province":"四川省","city":"泸州市","address":"四川省 · 泸州市 · 江村","device":"Android","createTime":"2020-02-13 18:47:12","modifiedTime":"2020-02-13 18:47:12","isDeleted":0,"type":"END","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":"","attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-13","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-13 18:47:12","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581590832279,"attendanceTypeNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1},{"attendanceId":"5424ca8909bd46898f34f56d8650f841","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349772","latitude":"28.104204","country":"中国","province":"四川省","city":"泸州市","address":"四川省 · 泸州市 · 江村","device":"Android","createTime":"2020-02-13 18:46:07","modifiedTime":"2020-02-13 18:46:07","isDeleted":0,"type":"END","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":"","attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-13","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-13 18:46:07","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581590767126,"attendanceTypeNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1},{"attendanceId":"a09540ec8b63471fa0a1702aada39835","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349772","latitude":"28.104204","country":"中国","province":"四川省","city":"泸州市","address":"四川省 · 泸州市 · 江村","device":"Android","createTime":"2020-02-13 18:45:31","modifiedTime":"2020-02-13 18:45:31","isDeleted":0,"type":"END","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":"","attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-13","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-13 18:45:31","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581590731243,"attendanceTypeNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1},{"attendanceId":"6696e793cfd64b57b8e27aba4f705a00","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349701","latitude":"28.104124","country":null,"province":null,"city":null,"address":"四川省 · 泸州市 · 江村","device":"iOS","createTime":"2020-02-13 07:55:54","modifiedTime":"2020-02-13 07:55:54","isDeleted":0,"type":"START","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":null,"attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-13","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-13 07:55:54","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581551754921,"attendanceTypeNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1},{"attendanceId":"7957a66833c54b87b0f42a6f22df21d9","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349564","latitude":"28.104170","country":null,"province":null,"city":null,"address":"四川省 · 泸州市 · 江村","device":"iOS","createTime":"2020-02-12 18:46:50","modifiedTime":"2020-02-12 18:46:50","isDeleted":0,"type":"END","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":null,"attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-12","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-12 18:46:50","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581504410428,"attendanceTyp 691 eNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1},{"attendanceId":"97df25b71d6240ca8b0546e28d1e24cb","userId":"101484997","memberId":"3083b520c697530115a9b06e5c3e14c0","longitude":"105.349675","latitude":"28.104166","country":null,"province":null,"city":null,"address":"四川省 · 泸州市 · 江村","device":"iOS","createTime":"2020-02-12 07:43:08","modifiedTime":"2020-02-12 07:43:08","isDeleted":0,"type":"START","schoolId":"2e1574e92516c58ef5ae386b131f0bf9","planId":"d1109cbc8c3264ea844d219fee2c0646","attachments":null,"state":"NORMAL","description":null,"attendanceType":null,"isReplace":0,"appUuid":null,"snowFlakeId":1000004,"dateYmd":"2020-02-12","memberNumber":"201761021203120","username":"宋连华","submitTime":null,"attendenceTime":"2020-02-12 07:43:08","backup":null,"headImg":"f005585371b08470a447374c1a8e85c7.png","orgEntity":{"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"},"teacherId":null,"grade":"2017","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","attendenceTimeLong":1581464588707,"attendanceTypeNumber":1,"userIdNumber":101484997,"gradeNumber":2017,"stateNumber":1}]
     * flag : 10
     */

    private int code;
    private String msg;
    private int flag;
    private List<DataBean> data;

    @NoArgsConstructor
    @Data
    public static class DataBean {
        /**
         * attendanceId : beb4f473f8bc4e4e97120d697f2a2888
         * userId : 101484997
         * memberId : 3083b520c697530115a9b06e5c3e14c0
         * longitude : 105.349764
         * latitude : 28.104204
         * country : 中国
         * province : 四川省
         * city : 泸州市
         * address : 四川省 · 泸州市 · 江村
         * device : Android
         * createTime : 2020-02-14 15:38:00
         * modifiedTime : 2020-02-14 15:38:00
         * isDeleted : 0
         * type : END
         * schoolId : 2e1574e92516c58ef5ae386b131f0bf9
         * planId : d1109cbc8c3264ea844d219fee2c0646
         * attachments : null
         * state : NORMAL
         * description :
         * attendanceType : null
         * isReplace : 0
         * appUuid : null
         * snowFlakeId : 1000004
         * dateYmd : 2020-02-14
         * memberNumber : 201761021203120
         * username : 宋连华
         * submitTime : null
         * attendenceTime : 2020-02-14 15:38:00
         * backup : null
         * headImg : f005585371b08470a447374c1a8e85c7.png
         * orgEntity : {"schoolId":"2e1574e92516c58ef5ae386b131f0bf9","schoolName":"成都工业职业技术学院","depName":"信息工程学院","depId":"0d1561ca0c221779c9aad564cfe42e37","majorId":"404e33e181e941dc98de9a25e5dfb525","classId":"c9580ce87c0e8c41838ef4308ffb8ee5","majorField":null,"majorName":"移动应用开发","className":"Z移动1704","studentId":"3083b520c697530115a9b06e5c3e14c0","teacheId":null,"userName":"宋连华","snowFlakeId":1000004,"studentNumber":"201761021203120","teacherNumber":null,"grade":"2017"}
         * teacherId : null
         * grade : 2017
         * depId : 0d1561ca0c221779c9aad564cfe42e37
         * majorId : 404e33e181e941dc98de9a25e5dfb525
         * classId : c9580ce87c0e8c41838ef4308ffb8ee5
         * attendenceTimeLong : 1581665880444
         * attendanceTypeNumber : 1
         * userIdNumber : 101484997
         * gradeNumber : 2017
         * stateNumber : 1
         * attendanceTyp 691 eNumber : 1
         */

        private String attendanceId;
        private String userId;
        private String memberId;
        private String longitude;
        private String latitude;
        private String country;
        private String province;
        private String city;
        private String address;
        private String device;
        private String createTime;
        private String modifiedTime;
        private int isDeleted;
        private String type;
        private String schoolId;
        private String planId;
        private Object attachments;
        private String state;
        private String description;
        private Object attendanceType;
        private int isReplace;
        private Object appUuid;
        private int snowFlakeId;
        private String dateYmd;
        private String memberNumber;
        private String username;
        private Object submitTime;
        private String attendenceTime;
        private Object backup;
        private String headImg;
        private OrgEntityBean orgEntity;
        private Object teacherId;
        private String grade;
        private String depId;
        private String majorId;
        private String classId;
        private long attendenceTimeLong;
        private int attendanceTypeNumber;
        private int userIdNumber;
        private int gradeNumber;
        private int stateNumber;
        private int _$AttendanceTyp691ENumber294; // FIXME check this code

        @NoArgsConstructor
        @Data
        public static class OrgEntityBean {
            /**
             * schoolId : 2e1574e92516c58ef5ae386b131f0bf9
             * schoolName : 成都工业职业技术学院
             * depName : 信息工程学院
             * depId : 0d1561ca0c221779c9aad564cfe42e37
             * majorId : 404e33e181e941dc98de9a25e5dfb525
             * classId : c9580ce87c0e8c41838ef4308ffb8ee5
             * majorField : null
             * majorName : 移动应用开发
             * className : Z移动1704
             * studentId : 3083b520c697530115a9b06e5c3e14c0
             * teacheId : null
             * userName : 宋连华
             * snowFlakeId : 1000004
             * studentNumber : 201761021203120
             * teacherNumber : null
             * grade : 2017
             */

            private String schoolId;
            private String schoolName;
            private String depName;
            private String depId;
            private String majorId;
            private String classId;
            private Object majorField;
            private String majorName;
            private String className;
            private String studentId;
            private Object teacheId;
            private String userName;
            private int snowFlakeId;
            private String studentNumber;
            private Object teacherNumber;
            private String grade;
        }
    }
}

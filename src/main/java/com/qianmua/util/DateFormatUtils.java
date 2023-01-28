package com.qianmua.util;

import com.qianmua.constant.AutoManageType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/12  10:29
 * @description :
 */
public class DateFormatUtils {

    /**
     * 得到周天
     */
    public static Long getStartWithEndTime(){
        // start time
        LocalDate start = LocalDate.parse(AutoManageType.BASE_WEEK);
        LocalDate end = LocalDate.now();

        // 区间
        return ChronoUnit.DAYS.between(start, end);
    }

    /**
     * @return current time [String]
     */
    public static String getNow(){
        return LocalDateTime.now().toString().replaceAll("T" , " ");
    }

    public static String getStartDateTime(){
        return LocalDateTime
                .parse(AutoManageType.BASE_WEEK + " 00:00:01",
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                        .plusWeeks(1)
                        .toString()
                        .replaceAll("T", " ");
    }

    public static String getEndDateTime(){
        return LocalDateTime
                .parse(AutoManageType.BASE_WEEK + " 23:59:59",
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                .plusWeeks(2)
                .minusDays(1)
                .toString()
                .replaceAll("T", " ");
    }

    public static boolean isThisMonthLast(){
        return LocalDate.now()
                .isAfter(LocalDate.now()
                        .with(TemporalAdjusters.lastDayOfMonth())
                        .minusDays(1));
    }

    public static boolean isThisWeekSaturday(){
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.SATURDAY) && LocalTime.now().getHour() < 12;
    }

    public static boolean isDayLast(){
        // text
        return LocalTime.now().getHour() < 12;
    }

    /**
     * 得到当前月
     * @return
     */
    public static String getMonth(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
    }

}

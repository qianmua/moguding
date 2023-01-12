package com.qianmua.util;

import org.slf4j.Logger;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/11 13:24          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/11 13:24
 * @since JDK1.8
 */
@SuppressWarnings(value = "ALL")
public class LogUtils {

    /**
     * category - step number - content
     */
    private static final String LOG = "[ {} Log ] - [Step - {}] : []";

    public LogUtils() {}

    public static void logEvent(Logger logger , String stepNumber , String content) {
        if (logger.isInfoEnabled()) {
            logger.info(LOG , new Object[]{stepNumber , "Event" , content});
        }
    }

    public static void logCondition(Logger logger , String stepNumber , Boolean content) {
        if (logger.isInfoEnabled()) {
            logger.info(LOG , new Object[]{stepNumber , "Condition" , content});
        }
    }

}

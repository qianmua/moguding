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
    private static final String LOG = "[ {} Log ] - [Step - {}] : [{}]";

    public LogUtils() {}

    public static void logEvent(Logger logger , String stepNumber , String content) {
        if (logger.isInfoEnabled()) {
            logger.info(LOG ,  "Event" ,stepNumber , content);
        }
    }

    /**
     * description：
     * <p>
     *     Info 级别普通日志输出
     * </p>
     * change history:
     * date                         defect#        person       comments
     * -----------------------------------------------------------------<p>
     * 2023-07-27                    ********       kong.ruo    create file.
     *
     * @author kong.ruo
     * @date 2023-07-27 15:12
     * @param	logger	log factory
     * @param	stepNumber	step
     * @param	content	content
     * @since JDK1.8
     */
    public static void logInfo(Logger logger , String content) {
        if (logger.isInfoEnabled()) {
            logger.info(LOG , "Info" ,content);
        }
    }

    /**
     * description：
     * <p>
     *     Info 级别参数输出
     * </p>
     * change history:
     * date                         defect#        person       comments
     * -----------------------------------------------------------------<p>
     * 2023-07-27                    ********       kong.ruo    create file.
     *
     * @author kong.ruo
     * @date 2023-07-27 15:12
     * @param	logger	log factory
     * @param	stepNumber	step
     * @param	content	content
     * @since JDK1.8
     */
    public static void logStrut(Logger logger ,String stepNumber , String content) {
        if (logger.isInfoEnabled()) {
            logger.info(LOG , "Strut" ,stepNumber ,content);
        }
    }

    /**
     * description：
     * <p>
     *     针对 Error 级别日志输出
     * </p>
     * change history:
     * date                         defect#        person       comments
     * -----------------------------------------------------------------<p>
     * 2023-07-27                    ********       kong.ruo    create file.
     *
     * @author kong.ruo
     * @date 2023-07-27 17:47
     * @param	logger
     * @param	stepNumber
     * @param	content
     * @since JDK1.
     */
    public static void logError(Logger logger , String stepNumber , String content) {
        if (logger.isErrorEnabled()) {
            logger.error(LOG ,  "Error" ,stepNumber , content);
        }
    }

    /**
     * description：
     * <p>
     *     条件判断使Trace用级别日志
     * </p>
     * change history:
     * date                         defect#        person       comments
     * -----------------------------------------------------------------<p>
     * 2023-07-27                    ********       kong.ruo    create file.
     *
     * @author kong.ruo
     * @date 2023-07-27 15:24
     * @param	logger
     * @param	stepNumber
     * @param	content
     * @since JDK1.8
     */
    public static void logCondition(Logger logger , String stepNumber , Boolean content) {
        if (logger.isTraceEnabled()) {
            logger.trace(LOG , "Condition" , stepNumber , content);
        }
    }

}

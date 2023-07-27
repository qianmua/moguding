package com.qianmua.framework.support;

import com.qianmua.common.ErrorCode;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/12 11:30          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/12 11:30
 * @since JDK1.8
 */
public abstract class Assert {

    public static void check(ErrorCode errorCode, Object ... args) {
        check(true , errorCode , args);
    }

    public static void check(boolean expression , ErrorCode errorCode , Object ... args) {
        if (expression) {
            throw new RuntimeException(String.format(errorCode.getErrorMsg() , args));
        }
    }


}

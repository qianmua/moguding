package com.qianmua.common.errorcode;

import com.qianmua.common.ErrorCode;

/**
 * description：
 * <p>
 * </p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------<p>
 * 2023/7/27 15:39          ********    ruo kong    create file.
 *
 * @author ruo kong
 * @date 2023/7/27 15:39
 * @since JDK1.8
 */
public enum BaseErrorCodeEnum implements ErrorCode {
    SYSTEM_ERROR("System Error. Msg: {%s}") ,

    ;

    private final String errorMsg;

    BaseErrorCodeEnum(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}

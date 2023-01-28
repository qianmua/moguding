package com.qianmua.framework.support;

import com.qianmua.util.DateFormatUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 10:18          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 10:18
 * @since JDK1.8
 */
@Data
public class MsgHeader implements Serializable {

    private String retCode;

    private String retMsg;

    private String serverTime;

    public static MsgHeader getInstance() {
        MsgHeader msgHeader = new MsgHeader();

        msgHeader.setServerTime(DateFormatUtils.getNow());

        return msgHeader;
    }

}

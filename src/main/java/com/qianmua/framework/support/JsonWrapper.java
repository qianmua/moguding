package com.qianmua.framework.support;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Objects;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 10:16          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 10:16
 * @since JDK1.8
 */
@Slf4j
@Data
public class JsonWrapper implements Serializable {

    private MsgHeader msgHeader;

    private Object msgBody;

    public static JsonWrapper respSuccess(Object body) {
        JsonWrapper jsonWrapper = new JsonWrapper();
        MsgHeader msgHead = CacheLocal.getMsgHead();
        if (Objects.nonNull(msgHead)) {
            msgHead.setRetCode("0");
            msgHead.setRetMsg("");
        }
        jsonWrapper.setMsgBody(body);
        return jsonWrapper;
    }

    public static JsonWrapper respSuccess(){
        JsonWrapper jsonWrapper = new JsonWrapper();
        MsgHeader msgHead = CacheLocal.getMsgHead();
        if (Objects.nonNull(msgHead)) {
            msgHead.setRetCode("0");
            msgHead.setRetMsg("");
        }

        return jsonWrapper;
    }
}

package com.qianmua.framework.support;

import com.qianmua.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 10:46          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 10:46
 * @since JDK1.8
 */
@Slf4j
@Component
public class CacheLocal {

    private static ThreadLocal<ConcurrentHashMap<String , Object>> LOCAL_THREAD = new ThreadLocal<>();

    public static void setMsgHead(MsgHeader msgHeader) {
        ConcurrentHashMap<String, Object> map = getMap();
        map.put(Constant.MSG_HEAD , msgHeader);
    }

    public static MsgHeader getMsgHead() {
        ConcurrentHashMap<String, Object> map = getMap();

        MsgHeader msgHeader = null;
        Object o = map.get(Constant.MSG_HEAD);
        if (Objects.nonNull(o)) {
            if( o instanceof MsgHeader) {
                msgHeader = (MsgHeader) o;
            }else {
                // throw exception.
            }
        }
        return msgHeader;
    }

    public static void clean() {
        LOCAL_THREAD.remove();
    }

    private static ConcurrentHashMap<String, Object> getMap() {
        ConcurrentHashMap<String, Object> map = LOCAL_THREAD.get();
        if (Objects.isNull(map)) {
            map = new ConcurrentHashMap<>();
        }
        return map;
    }

}

package com.qianmua.handle;

import com.qianmua.chain.InvokeHandler;
import com.qianmua.constant.AutoManageType;
import com.qianmua.entity.vo.SinginVo;
import com.qianmua.framework.support.NetworkApi;
import com.qianmua.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/12 14:14          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/12 14:14
 * @since JDK1.8
 */
@Component
@Slf4j
public class AutoSignHandle implements InvokeHandler {

    private static final String URL = "";

    @Override
    public void execute(SinginVo singinVo, String token, AutoManageType.Type type) {
        String sign = URL + "/attendence/clock/v1/save";
        NetworkApi.request(JsonUtils.serialize(singinVo), sign, token,
                json1 -> { });
    }
}

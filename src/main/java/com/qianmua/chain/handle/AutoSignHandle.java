package com.qianmua.chain.handle;

import com.qianmua.chain.InvokeHandler;
import com.qianmua.constant.MogudingApiUri;
import com.qianmua.constant.PublishTypeEnum;
import com.qianmua.entity.vo.SinginVo;
import com.qianmua.framework.support.NetworkApi;
import com.qianmua.util.JsonUtils;
import com.qianmua.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${mogu.service.sign-uri}")
    private String uri;

    @Override
    public void execute(SinginVo singinVo, String token, PublishTypeEnum type) {
        String sign = uri + MogudingApiUri.AUTO_CLOCK_URI;
        LogUtils.logEvent(log , "Sign" , "Execute Sign");
        NetworkApi.request(JsonUtils.serialize(singinVo), sign, token,
                json1 -> { });
    }
}

package com.qianmua.service.impl;

import com.qianmua.handle.SignHandle;
import com.qianmua.service.SignService;
import com.qianmua.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 16:57          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 16:57
 * @since JDK1.8
 */
@Service
@Slf4j
public class SignServiceImpl implements SignService {

    private final SignHandle signHandle;

    public SignServiceImpl(SignHandle signHandle) {
        this.signHandle = signHandle;
    }

    @Override
    public void signAll() {
        LogUtils.logEvent(log , "signReq" , "sign Request");
        signHandle.signReq();
    }

    @Override
    public void signByUID(String uid) {

    }
}

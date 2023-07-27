package com.qianmua.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.qianmua.common.errorcode.BaseErrorCodeEnum;
import com.qianmua.entity.Login;
import com.qianmua.framework.support.Assert;
import com.qianmua.chain.handle.SignHandle;
import com.qianmua.service.SignService;
import com.qianmua.service.UserService;
import com.qianmua.util.LogUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
@RequiredArgsConstructor
public class SignServiceImpl implements SignService {

    private final SignHandle signHandle;
    private final UserService userService;

    @Override
    public void signAll() {
        List<Login> loginList = userService.queryAllUserInfo();
        LogUtils.logEvent(log , "CollectionUtil.isEmpty(loginList)" , "Empty");
        Assert.check(CollUtil.isEmpty(loginList) , BaseErrorCodeEnum.SYSTEM_ERROR , "Array Empty");

        LogUtils.logEvent(log , "signReq" , "sign Request");
        signHandle.signReq(loginList);
    }

    @Override
    public void signByUID(String uid) {
        Assert.check(StrUtil.isEmpty(uid) , BaseErrorCodeEnum.SYSTEM_ERROR , " uid Empty");
        LogUtils.logEvent(log , "Query User By UID" , uid);
        Login login = userService.queryByUID(uid);
        LogUtils.logEvent(log , "signReq" , "sign Request");

        signHandle.signReq(
                new ArrayList<Login>() {{
                    add(login);
                }});
    }
}

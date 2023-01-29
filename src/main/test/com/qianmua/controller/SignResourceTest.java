package com.qianmua.controller;

import com.qianmua.Application;
import com.qianmua.service.SignService;
import com.qianmua.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/29 14:47          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/29 14:47
 * @since JDK1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@Slf4j
public class SignResourceTest {

    @Autowired
    private SignService signService;

    public static final String UID = "1";

    @Test
    public void testSignByID() {
        // test uid -> 1
        LogUtils.logEvent(log , "test Sign By UID" , UID);
        signService.signByUID(UID);
        LogUtils.logEvent(log, "Sign Success" , "Done");
    }
}

package com.qianmua.controller;

import com.qianmua.framework.support.JsonWrapper;
import com.qianmua.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 16:47          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 16:47
 * @since JDK1.8
 */
@RestController
@RequestMapping("/mogu/res")
@Slf4j
public class SignResource {

    private final SignService signService;

    public SignResource(SignService signService) {
        this.signService = signService;
    }

    @GetMapping("/sign")
    public JsonWrapper signAll() {

        signService.signAll();

        return JsonWrapper.respSuccess();
    }

    @GetMapping("/sign/{uid}")
    public JsonWrapper signUID(@PathVariable String uid) {

        signService.signByUID(uid);

        return JsonWrapper.respSuccess();
    }


}

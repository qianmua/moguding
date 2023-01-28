package com.qianmua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 14:59          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 14:59
 * @since JDK1.8
 */
//@RestController
@Controller
@RequestMapping("/mogu")
public class IndexResource {

    @GetMapping("/index")
    public String index() {
        return "index.html";
    }
}


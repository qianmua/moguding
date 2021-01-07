/**
 * <p>Title: GlobalExceptionHandler.java</p>
 * <p>Description: 统一异常处理</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: 深圳市中钞信达成都研发中心</p>
 *
 * @author noel
 * @date 2019年9月12日
 */
package com.qianmua.config;
import com.qianmua.util.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.mail.MessagingException;

/**
 * 统一异常处理
 *
 * @author noel
 * @date 2019年9月12日
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final EmailUtil emailUtil;

    public GlobalExceptionHandler(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    /**
     * 其它全局异常
     *
     * @param e 异常
     * @return com.cbpm.crrc.logicmodel.ResultMsg
     * @author noel
     * @date 2020/5/20
     * version 1.0
     **/
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public String handleException(Throwable e) throws MessagingException {

        log.error(" e.message [from exception] : {}" , e.getMessage());
        emailUtil.signErrorMailNotify(e.getMessage(),e.toString());

        return "服务器发生异常";
    }
}
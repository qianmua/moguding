package com.qianmua.mail;

import javax.mail.MessagingException;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/8  9:51
 * @description :
 */
@FunctionalInterface
public interface ExecuteSendMailFunction {

    void execute(String message) throws MessagingException;

}

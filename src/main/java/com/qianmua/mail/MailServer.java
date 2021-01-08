package com.qianmua.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author 宋涛
 * @version 1.0
 * @date 2020/7/28 14:55
 *
 * change by qianmu 21/01/08
 * 使用回调机制重新处理
 */
@Component
@Slf4j
public class MailServer {


    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.send-mail-from}")
    private String sendFrom;
    @Value("${mail.send-mail-to}")
    private String sendTo;
    @Value("${mail.mogu-send-title}")
    private String title;

    /**
     * 任务回执
     * @param message 消息内容
     * @param e 。
     * @throws MessagingException 消息异常
     */
    public void signErrorMailNotify(String message,String e) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setSubject("mogu auto clock");
        messageHelper.setFrom(sendFrom);
        messageHelper.setTo(sendTo);
        messageHelper.setText("<h1>" + "" + "error message : " + message+"      "+e, true);
        javaMailSender.send(messageHelper.getMimeMessage());
    }

    public void signMailNotify(String message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setSubject("mogu auto clock.");
        messageHelper.setFrom(sendFrom);
        messageHelper.setTo(sendTo);
        messageHelper.setText("<h1>" + message + "</h1>", true);
        javaMailSender.send(messageHelper.getMimeMessage());
    }




}

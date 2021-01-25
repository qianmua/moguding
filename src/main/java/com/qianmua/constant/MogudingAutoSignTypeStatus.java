package com.qianmua.constant;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/8  18:31
 * @description : 定义邮件发送内容显示类型
 */
public enum MogudingAutoSignTypeStatus {

    SIGN("签到状态") , DAY("日报状态") , WEEK("周报状态") , MONTH("日报状态");

    private final String symbol;

    MogudingAutoSignTypeStatus(String symbol){
        this.symbol = symbol;
    }
}

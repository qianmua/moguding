package com.qianmua.constant;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  19:30
 * @description : 使用tools 构造比较方便
 */
public enum MogudingApiUri {

    BASE_URI("https://api.moguding.net:9000"),
    LOGIN_URI("/session/user/v1/login"),
    GET_TOKEN_URI("/practice/plan/v1/getPlanByStu"),
    AUTO_WRITE_URI("/practice/paper/v1/save"),
    AUTO_CLOCK_URI("/attendence/clock/v1/save");

    private final String symbol;

    MogudingApiUri(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

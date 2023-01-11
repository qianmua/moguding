package com.qianmua.constant;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/10 17:54          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/10 17:54
 * @since JDK1.8
 */
public enum SignStatusEnum {
    SUCCESS("SUCCESS") , FAIL("FAIL") , RUNNING("RUNNING");

    private final String symbol;

    SignStatusEnum(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

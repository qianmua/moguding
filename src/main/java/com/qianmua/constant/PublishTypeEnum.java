package com.qianmua.constant;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 09:36          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 09:36
 * @since JDK1.8
 */
public enum PublishTypeEnum {
    AUTO_DAILY("day") ,
    AUTO_WEEKLY("week") ,
    AUTO_MONTHLY("month"),
    AUTO_SIGN("sign"),

    /**
     * day 2023-1-28 add
     */
    AUTO_DAY_WEEKLY("day-week"),
    AUTO_DAY_MONTHLY("day-month"),
    AUTO_WEEKLY_MONTHLY("week-month"),

    NIL(""),
            ;

    private final String symbol;

    PublishTypeEnum(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

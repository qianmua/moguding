package com.qianmua.service;

/**
 * description：
 * <p>
 * <p>
 * change history:
 * date                      defect#    person       comments
 * -------------------------------------------------------------
 * 2023/1/28 16:56          ********   jinchao.hu    create file.
 *
 * @author jinchao.hu
 * @date 2023/1/28 16:56
 * @since JDK1.8
 */
public interface SignService {

    /**
     * 对所有用户进行 手动签到
     *
     */
    void signAll();

    /**
     * 根据UID 登录
     * @param uid user唯一识别码
     */
    void signByUID(String uid);

}

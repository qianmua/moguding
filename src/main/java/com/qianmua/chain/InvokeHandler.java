package com.qianmua.chain;

import com.qianmua.constant.PublishTypeEnum;
import com.qianmua.entity.vo.SinginVo;

/**
 * description : 调用链
 *
 * @author jinchao.hu
 * @date 2021/1/25  19:07
 */
public interface InvokeHandler {
    void execute(SinginVo singinVo , String token , PublishTypeEnum type);
}

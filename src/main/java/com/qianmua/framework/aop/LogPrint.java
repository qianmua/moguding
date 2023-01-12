package com.qianmua.framework.aop;

import com.qianmua.framework.annotation.LogNotify;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/9  16:36
 * @description :
 */
@Aspect
@Component
public class LogPrint {

    @Pointcut("execution(* com.qianmua.service..*(..))")
    public void asp(){}


    @Before("@annotation(log)")
    public void doBefore(JoinPoint joinPoint , LogNotify log){

    }

    @After("@annotation(log)")
    public void doAfter(LogNotify log){

    }

    @Around("asp() && @annotation(log)")
    public Object doAround(ProceedingJoinPoint joinPoint , LogNotify log) throws Throwable {

        joinPoint.proceed();

        return null;

    }


}

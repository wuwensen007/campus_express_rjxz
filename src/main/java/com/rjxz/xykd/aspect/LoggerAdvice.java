package com.rjxz.xykd.aspect;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志记录增强类
 */
@Component
@Aspect
public class LoggerAdvice {

    private final Logger logger = Logger.getLogger(LoggerAdvice.class);

    @Around(value = "execution(* com.rjxz.xykd.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint){

        logger.debug(joinPoint.getSignature().getName() + "方法开始执行, 方法参数为"+ Arrays.toString(joinPoint.getArgs()));
        Object obj = null;
        try {
            obj = joinPoint.proceed();
            logger.debug(joinPoint.getSignature().getName() + "方法执行完毕, 方法参数为"+ Arrays.toString(joinPoint.getArgs())+ "方法返回值是:" + obj);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error(joinPoint.getSignature().getName() + "方法执行失败,出现异常!", throwable);
        }finally {
            logger.debug(joinPoint.getSignature().getName() + "方法,资源释放完毕!");
        }
        return obj;
    }

    @Around(value = "execution(* com.rjxz.xykd.controller.AccountController.updatePwd(..))")
    public Object aroundPwd(ProceedingJoinPoint joinPoint)
    {
        return around(joinPoint);
    }



}

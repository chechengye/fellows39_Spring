package com.weichuang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 代码模拟通知类
 */

//标记此类为一个切面
@Aspect
public class MyAdvice {

    //提取
    @Pointcut("execution(* com.weichuang.proxy.*ServiceImpl.*(..))")
    public void pc(){}

    @Before("MyAdvice.pc()")
    public void before(){
        System.out.println("前置通知!");
    }
    @AfterReturning("MyAdvice.pc()")
    public void afterReturning(){
        System.out.println("必须程序正常执行之后的通知");
    }

    public void throwing(){
        System.out.println("异常通知!");
    }

    public void finalAfter(){
        System.out.println("最终通知!");//无论是否出现异常都会通知
    }

    public Object around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("前环绕通知");
        Object proceed = pj.proceed();
        System.out.println("后环绕通知");
        return proceed;
    }
}

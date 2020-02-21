package com.weichuang.proxy;

import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserJVMFactory implements InvocationHandler{
    private IUserService us;

    public UserJVMFactory(IUserService us){
        this.us = us;
    }

    public IUserService getProxyUserService() {
        return (IUserService) Proxy.newProxyInstance(us.getClass().getClassLoader() , us.getClass().getInterfaces() , this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JVM前操作");
        Object obj = method.invoke(us, args);
        System.out.println("JVM后操作");
        return obj;
    }
}

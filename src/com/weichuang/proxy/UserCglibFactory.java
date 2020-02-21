package com.weichuang.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理,继承式代理
 */
public class UserCglibFactory implements MethodInterceptor{

    public IUserService getProxyUserService(){
        Enhancer en = new Enhancer();//生成动态代理对象的对象
        en.setSuperclass(UserServiceImpl.class); //指定被代理对象
        en.setCallback(this);//代理过程，增强，过滤
        IUserService us  = (IUserService)en.create();//创建代理对象，或者被代理后对象
        return us;
    }
    @Override
    public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib前过滤");
        Object obj = methodProxy.invokeSuper(proxyObj, args);
        System.out.println("Cglib后过滤");
        return obj;
    }
}

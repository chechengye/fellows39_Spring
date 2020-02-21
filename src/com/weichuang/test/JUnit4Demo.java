package com.weichuang.test;

import com.weichuang.annotation.Person;
import com.weichuang.proxy.IUserService;
import com.weichuang.proxy.UserCglibFactory;
import com.weichuang.proxy.UserJVMFactory;
import com.weichuang.proxy.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/weichuang/annotation/annotation.xml")
public class JUnit4Demo {
    @Autowired
    Person person;
    @Autowired
    IUserService us;
    @Test
    public void testFn(){
        //会默认使用完了此对象，自动关闭
        System.out.println(person);
    }

    @Test
    public void testFn1(){
        UserJVMFactory userJVMFactory = new UserJVMFactory(us);
        IUserService proxyUserService = userJVMFactory.getProxyUserService();
        proxyUserService.addUser();
        //接口式代理方式，代理对象与被代理对象没有关系。
        System.out.println(proxyUserService instanceof UserServiceImpl);
    }

    @Test
    public void testFn2(){
        UserCglibFactory userCglibFactory = new UserCglibFactory();
        IUserService proxyUserService = userCglibFactory.getProxyUserService();
        proxyUserService.updateUser(1);
        //instanceof : 多态，判断 前面的对象是否属于后面的对象
        System.out.println(proxyUserService instanceof UserServiceImpl);
    }
}

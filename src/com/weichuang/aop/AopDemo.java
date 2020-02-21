package com.weichuang.aop;

import com.weichuang.proxy.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/weichuang/aop/applicationContext.xml")
public class AopDemo {
    @Autowired
    IUserService userService;
    @Test
    public void testFn(){
        userService.deleteUser(1);
    }
}

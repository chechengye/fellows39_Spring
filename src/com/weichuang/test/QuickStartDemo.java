package com.weichuang.test;

import com.weichuang.annotation.Person;
import com.weichuang.pojo.User;
import com.weichuang.utils.CollectionDemo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuickStartDemo {

    @Test
    public void testFn(){
        //User u = new User();
        /*
            ClassPathXmlApplicationContext : 配置文件的对象
            使用getBean方法来获取，xml文件中已经配置好的bean，默认寻找name属性
            目前由于计算机性能的提高，所以只要Spring配置文件被加载的时候，内部的所有的对象就已经被实例化了。
            默认调用的是无参的构造方法。
         */
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = (User)applicationContext.getBean("a1");
        User user1 = (User)applicationContext.getBean("a3");
        System.out.println(user == user1);
        user.setName("zhangsan");
        System.out.println(user);
        //applicationContext.close();//做对象销毁操作
    }
    @Test
    public void testFn1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user1 = (User)applicationContext.getBean("b1");
        user1.setName("zhaoliu");
        System.out.println(user1);
    }

    /**
     * 测试三种对象创建的方式
     */
    @Test
    public void testFn2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = (User)applicationContext.getBean("user3");
        System.out.println(user);
    }

    /**
     * 测试注入
     */
    @Test
    public void testFn3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/weichuang/injection/injection.xml");
        User user = (User)applicationContext.getBean("user4");
        System.out.println(user);
    }

    /**
     * 测试复杂类型注入
     */
    @Test
    public void testFn4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/weichuang/injection/injection.xml");
        CollectionDemo cm = (CollectionDemo)applicationContext.getBean("collectionDemo");
        System.out.println(cm);
    }

    /**
     * 测试注解配置
     */
    @Test
    public void testFn5(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/weichuang/annotation/annotation.xml");
        Person person = (Person)applicationContext.getBean("person1");
        System.out.println(person);
    }
}

package com.weichuang.annotation;

import com.weichuang.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 将添加此注解的类，动态配置于xml中,相当于之前的bean
 * @Component : 作用于vo，pojo包下的 ,名称默认是将类名首字母小写
 * @Controller : 作用于controller包或web包，SpringMVC关注的注解
 * @Service : 作用于service层
 * @Repository : 作用于dao层或mapper层
 */
@Component(value = "person1")
//@Scope(value = "prototype")
public class Person {
    //属性注入，通过反射机制，破坏了封装性
    //@Value("张三")
    private String name;
    //@Value("33")
    private int age;
    /**
     * @Autowired ： 自动装配，自动注入。默认找的配置对象的首字母小写。
     * 若是此对象有多个名称，还不存在首字母小写的名称，即报错。只有一个对象时，还不存在首字母小写的名称，不会报错。
     * 若是此对象有多个名称，还不存在首字母小写的名称，即报错的解决方案是与@Qualifier(value = "car2")配合使用，由此注解来进行名称匹配
     * @Resource(name = "car1") 相当于 @Autowired  @Qualifier(value = "car2")俩配合使用
     *
     * 企业中使用最多的@Autowired 。通常对象只会存在一个
     */
    /*@Autowired
    @Qualifier(value = "car2")*/
    @Resource(name = "car1")
    private Car car;

    public String getName() {
        return name;
    }
    //set方法注入推荐使用
    @Value("李四")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    @Value("26")
    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    /*@PostConstruct
    public void init(){
        System.out.println("初始化方法!");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁方法!");
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}

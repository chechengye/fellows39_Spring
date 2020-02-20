package com.weichuang.utils;

import com.weichuang.pojo.User;

public class UserFactory {

    /**
     * 静态方法创建
     * @return
     */
    public static User createUser(){
        return new User();
    }

    /**
     * 实例方法创建
     * @return
     */
    public User createUser2(){
        return new User();
    }
}

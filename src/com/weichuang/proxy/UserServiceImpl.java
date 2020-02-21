package com.weichuang.proxy;

import com.weichuang.pojo.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService{
    @Override
    public void addUser() {
        System.out.println("添加用户方法");
        //int i = 1/ 0;
    }

    @Override
    public User getUser(int id) {
        System.out.println("获取用户方法");
        return null;
    }

    @Override
    public void deleteUser(int id) {
        System.out.println("删除用户方法");
    }

    @Override
    public void updateUser(int id) {
        System.out.println("更新用户方法");
    }
}

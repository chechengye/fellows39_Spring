package com.weichuang.proxy;

import com.weichuang.pojo.User;

public interface IUserService {
    void addUser();
    User getUser(int id);
    void deleteUser(int id);
    void updateUser(int id);
}

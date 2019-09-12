package com.hx.zibiao.service;

import com.hx.zibiao.pojo.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    List<User> getUsers();


    List<User> testT();
}

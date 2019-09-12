package com.hx.zibiao.service.impl;

import com.hx.zibiao.dao.UserDao;
import com.hx.zibiao.pojo.User;
import com.hx.zibiao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public List<User> testT() {
//添加了事务 并且生效了
        User user = new User();
        user.setId(16);
        user.setName("第十6");
        userDao.addUser(user);
        //如果注释掉事务注解 则会添加成功一条
        userDao.addUser(user);


        return userDao.getUsers();
    }
}

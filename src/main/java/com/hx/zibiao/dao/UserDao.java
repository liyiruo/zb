package com.hx.zibiao.dao;

import com.hx.zibiao.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * dao层的接口都要添加这个注解
 */
@Mapper
public interface UserDao {
    //方法名很重要
    int addUser(User user);
    List<User> getUsers();
}

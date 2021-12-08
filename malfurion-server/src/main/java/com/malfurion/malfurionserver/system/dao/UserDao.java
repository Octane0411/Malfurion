package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.User;

import java.util.List;

public interface UserDao {

    List<User> selectUserList();

    int insertUser(User user);

    User selectUserByName(String username);

    int updateUser(User user);

    User selectUserById(Long id);
}

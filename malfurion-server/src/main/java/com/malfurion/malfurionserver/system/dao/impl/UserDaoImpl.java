package com.malfurion.malfurionserver.system.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.malfurion.malfurionserver.system.dao.UserDao;
import com.malfurion.malfurionserver.system.entity.User;
import com.malfurion.malfurionserver.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;

    public List<User> selectUserList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(wrapper);
        return users;
    }

    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    public User selectUserByName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        return userMapper.selectOne(wrapper);
    }

    public int updateUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", user.getUserId());
        return userMapper.update(user, wrapper);
    }

    public User selectUserById(Long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", id);
        return userMapper.selectOne(wrapper);
    }
}

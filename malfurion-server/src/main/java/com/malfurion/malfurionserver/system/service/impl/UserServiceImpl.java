package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.system.dao.impl.UserDaoImpl;
import com.malfurion.malfurionserver.system.entity.User;
import com.malfurion.malfurionserver.system.mapper.UserMapper;
import com.malfurion.malfurionserver.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserDaoImpl userDaoImpl;

    @Override
    public boolean insertUser(User user) {
        return userDaoImpl.insertUser(user) > 0;
    }

    @Override
    public User selectUserByName(String username) {
        return userDaoImpl.selectUserByName(username);
    }

    @Override
    public boolean updateUserProfile(User user) {
        return userDaoImpl.updateUser(user) > 0;
    }

    @Override
    public User selectUserById(Long id) {
        return selectUserById(id);
    }
}

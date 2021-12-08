package com.malfurion.malfurionserver.system.service;

import com.malfurion.malfurionserver.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
public interface UserService extends IService<User> {

    boolean insertUser(User user);

    User selectUserByName(String username);

    boolean updateUserProfile(User user);

    User selectUserById(Long id);
}

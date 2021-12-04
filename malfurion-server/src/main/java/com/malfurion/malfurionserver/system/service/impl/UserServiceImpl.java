package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.system.entity.User;
import com.malfurion.malfurionserver.system.mapper.UserMapper;
import com.malfurion.malfurionserver.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}

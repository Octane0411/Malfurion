package com.malfurion.malfurionserver.common.config.sercurity.service;

import com.malfurion.malfurionserver.common.core.domain.LoginUser;

import com.malfurion.malfurionserver.common.enums.UserStatus;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.system.entity.User;
import com.malfurion.malfurionserver.system.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.malfurion.malfurionserver.common.exception.ServiceException;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.selectUserByName(username);
        if (StringUtils.isNull(user))
        {
            log.info("登录用户：{} 不存在.", username);
            throw new ServiceException("登录用户：" + username + " 不存在");
        }
        else if (user == null)
        {
            log.info("登录用户：{} 已被删除.", username);
            throw new ServiceException("对不起，您的账号：" + username + " 已被删除");
        }
        else if (UserStatus.DISABLE.getCode().equals(user.getStatus()))
        {
            log.info("登录用户：{} 已被停用.", username);
            throw new ServiceException("对不起，您的账号：" + username + " 已停用");
        }
        return createLoginUser(user);
    }

    public UserDetails createLoginUser(User user)
    {
        return new LoginUser(user.getUserId(), user);
    }
}

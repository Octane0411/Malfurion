package com.malfurion.malfurionserver.common.web.service.impl;

import com.malfurion.malfurionserver.common.constant.UserConstants;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.common.web.service.RegisterService;
import com.malfurion.malfurionserver.system.entity.User;
import com.malfurion.malfurionserver.system.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String register(User user) {
        String msg = "";
        String username = user.getUserName();
        String password = user.getPassword();
        if (StringUtils.isEmpty(username)) {
            msg = "用户名不能为空";
        } else if (StringUtils.isEmpty(password)) {
            msg = "密码不能为空";
        } else if (username.length() < 2 || username.length() > 20) {
            msg = "用户名长度应在2-20个字符间";
        } else if (password.length() < 2 || password.length() > 50) {
            msg = "密码长度应在2-50个字符间";
        } else if (userService.selectUserByName(username) != null) {
            msg = "该用户名已存在";
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setUserType("normal");
            boolean flag = userService.insertUser(user);
            if (!flag) {
                msg = "发生了未知的错误";
            } else {
                msg = "";
            }
        }
        return msg;
    }
}

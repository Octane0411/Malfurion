package com.malfurion.malfurionserver;

import com.github.pagehelper.PageHelper;
import com.malfurion.malfurionserver.common.config.sercurity.service.TokenService;
import com.malfurion.malfurionserver.common.core.redis.RedisCache;
import com.malfurion.malfurionserver.system.dao.impl.UserDaoImpl;
import com.malfurion.malfurionserver.system.entity.User;
import com.malfurion.malfurionserver.system.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

@SpringBootTest
class MalfurionServerApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDaoImpl userDaoImpl;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    TokenService tokenService;

    @Autowired
    RedisCache redisCache;

    @Test
    void testDataBaseConnection() {
        User user = new User();
        user.setUserName("octane");
        user.setPassword("1");
        user.setNickName("o");
        userMapper.insertUser(user);
        //List<User> users = userDao.selectUserList();
        //for (User user : users) {
        //    System.out.println(user);
        //}
    }

    @Test
    void testPasswordEncoding() {
        String password = "cillum Duis dolor1";
        boolean matches = bCryptPasswordEncoder.matches(password, "$2a$10$Wak9/6ToB5sgKB2jAceRjee1Lk8YqG55Mwds5gTsecF0bm/ohsWSS");
        System.out.println(matches);
    }

    @Test
    void testRedisChinese() {
        Collection<String> keys = redisCache.keys("*");
        System.out.println(keys.size());
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    void testPageHelper() {
        PageHelper.startPage(1, 2);
        List<User> users = userMapper.selectList(null);
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user);
        }
    }

}

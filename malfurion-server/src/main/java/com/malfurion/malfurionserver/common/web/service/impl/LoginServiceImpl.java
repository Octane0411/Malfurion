package com.malfurion.malfurionserver.common.web.service.impl;

import com.malfurion.malfurionserver.common.config.sercurity.service.TokenService;
import com.malfurion.malfurionserver.common.core.domain.LoginUser;
import com.malfurion.malfurionserver.common.core.domain.model.LoginBody;
import com.malfurion.malfurionserver.common.exception.ServiceException;
import com.malfurion.malfurionserver.common.core.redis.RedisCache;
import com.malfurion.malfurionserver.common.exception.user.UserPasswordNotMatchException;
import com.malfurion.malfurionserver.common.utils.DateUtils;
import com.malfurion.malfurionserver.common.utils.ServletUtils;
import com.malfurion.malfurionserver.common.utils.ip.IpUtils;
import com.malfurion.malfurionserver.common.web.controller.RegisterController;
import com.malfurion.malfurionserver.common.web.service.LoginService;
import com.malfurion.malfurionserver.system.entity.User;
import com.malfurion.malfurionserver.system.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import javax.annotation.Resource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public String login(LoginBody loginBody) {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        String uuid = loginBody.getUuid();
        String code = loginBody.getCode();


        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            }
            else
            {
                //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new ServiceException(e.getMessage());
            }
        }

        LoginUser user = (LoginUser)redisCache.getCacheMapValue("login_tokens", "login_tokens:" + uuid);
        if (user != null) {
            logger.info(user.toString());
            return tokenService.updateToken(user);
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserId());
        // 生成token
        return tokenService.createToken(loginUser);
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId)
    {
        User user = new User();
        user.setUserId(userId);
        user.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        user.setLoginDate(DateUtils.getNowDate());
        userService.updateUserProfile(user);
    }
}

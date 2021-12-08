package com.malfurion.malfurionserver.common.utils;

import com.malfurion.malfurionserver.common.constant.HttpStatus;
import com.malfurion.malfurionserver.common.core.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全服务工具类
 */
public class SecurityUtils {
    /**
     * 用户ID
     **/
    public static Long getUserId() {
        return getLoginUser().getUserId();
    }

    /**
     * 获取用户账户
     **/
    public static String getUsername() {
        return getLoginUser().getUsername();
    }

    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser() {
/*        Authentication authentication = getAuthentication();
        System.out.println("authentication" + authentication);
        Object principal = authentication.getPrincipal();
        System.out.println("principal" + principal);*/
        /*调用登录时这里会报错：java.lang.String cannot be cast to com.malfurion.malfurionserver.common.core.domain.LoginUser
        因为这时候还没登录，这里的principal确实是anonymousUser这个字符串，会抛出类型转换的异常
        */
        Object principal = getAuthentication().getPrincipal();
        if (principal instanceof LoginUser) {
            return (LoginUser) principal;
        } else if (principal instanceof String) {
            LoginUser loginUser = new LoginUser();
            return (LoginUser) principal;
        } else {
            return (LoginUser) principal;
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword     真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 是否为管理员
     *
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }
}

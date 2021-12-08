package com.malfurion.malfurionserver.common.config.sercurity.handler;

import com.alibaba.fastjson.JSON;
import com.malfurion.malfurionserver.common.config.sercurity.service.TokenService;
import com.malfurion.malfurionserver.common.constant.Constants;
import com.malfurion.malfurionserver.common.constant.HttpStatus;
import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.core.domain.LoginUser;
import com.malfurion.malfurionserver.common.utils.ServletUtils;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class MyLogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

    @Autowired
    TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getUuid());
            // 记录用户退出日志
            //AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, "退出成功"));
        }
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(HttpStatus.SUCCESS, "退出成功")));
    }
}

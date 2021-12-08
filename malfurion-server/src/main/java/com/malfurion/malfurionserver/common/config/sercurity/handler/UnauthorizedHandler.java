package com.malfurion.malfurionserver.common.config.sercurity.handler;

import com.alibaba.fastjson.JSON;
import com.malfurion.malfurionserver.common.constant.HttpStatus;
import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.utils.ServletUtils;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 认证失败
 */
@Component
public class UnauthorizedHandler implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        int code = HttpStatus.UNAUTHORIZED;
        String msg = StringUtils.format("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(code, msg)));
    }
}

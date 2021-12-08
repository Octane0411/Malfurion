package com.malfurion.malfurionserver.common.web.controller;

import com.malfurion.malfurionserver.common.constant.Constants;
import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.core.domain.LoginUser;
import com.malfurion.malfurionserver.common.core.domain.model.LoginBody;
import com.malfurion.malfurionserver.common.web.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    LoginServiceImpl loginService;


    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        logger.info("enterd login controller");
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
}

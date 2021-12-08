package com.malfurion.malfurionserver.common.web.controller;

import com.malfurion.malfurionserver.common.core.controller.SuperController;
import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.common.web.service.impl.RegisterServiceImpl;
import com.malfurion.malfurionserver.system.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController extends SuperController {

    private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    RegisterServiceImpl registerService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody User user) {
        logger.debug("register called:" + user.toString());
        System.out.println("register called:" + user.toString());
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}

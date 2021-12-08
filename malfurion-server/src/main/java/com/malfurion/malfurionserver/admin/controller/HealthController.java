package com.malfurion.malfurionserver.admin.controller;

import com.malfurion.malfurionserver.common.core.domain.LoginUser;
import com.malfurion.malfurionserver.common.utils.SecurityUtils;
import com.malfurion.malfurionserver.system.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @RequestMapping("/alive")
    public String healthResponse() {
        return "i'm alive";
    }

    @GetMapping("/testUser")
    public LoginUser testUser() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        return loginUser;
    }
}

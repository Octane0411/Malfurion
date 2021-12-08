package com.malfurion.malfurionserver.common.web.service;

import com.malfurion.malfurionserver.common.core.domain.model.LoginBody;

public interface LoginService {

    String login(LoginBody loginBody);
}

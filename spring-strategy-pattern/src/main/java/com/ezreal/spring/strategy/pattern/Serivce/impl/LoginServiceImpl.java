package com.ezreal.spring.strategy.pattern.Serivce.impl;

import com.ezreal.spring.strategy.pattern.Serivce.LoginService;
import com.ezreal.spring.strategy.pattern.factory.LoginHandlerFactory;
import com.ezreal.spring.strategy.pattern.handler.LoginHandler;
import com.ezreal.spring.strategy.pattern.model.LoginRequest;
import com.ezreal.spring.strategy.pattern.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created on 2021/6/25.
 *
 * @author Ezreal
 * @since 2.0.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginHandlerFactory factory;
    @Override
    public LoginResponse<String> login(LoginRequest request) {
        LoginHandler<Serializable> handler = factory.getHandler(request.getLoginType());

        return handler.handleLogin(request);
    }
}

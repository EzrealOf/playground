package com.ezreal.spring.strategy.pattern.controller;

import com.ezreal.spring.strategy.pattern.Serivce.LoginService;
import com.ezreal.spring.strategy.pattern.enums.LoginType;
import com.ezreal.spring.strategy.pattern.model.LoginRequest;
import com.ezreal.spring.strategy.pattern.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2021/6/25.
 *
 * @author Ezreal
 * @since 2.0.0
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public LoginResponse<String> login(@RequestParam LoginType loginType, @RequestParam Long userId) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginType(loginType);
        loginRequest.setUserId(userId);
        LoginResponse<String> login = loginService.login(loginRequest);
        return login;
    }

}

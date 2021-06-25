package com.ezreal.spring.strategy.pattern.handler;

import com.ezreal.spring.strategy.pattern.enums.LoginType;
import com.ezreal.spring.strategy.pattern.model.LoginRequest;
import com.ezreal.spring.strategy.pattern.model.LoginResponse;
import org.springframework.stereotype.Component;
import sun.rmi.log.LogHandler;

import java.io.Serializable;

/**
 * Created on 2021/6/25.
 *
 * @author Ezreal
 * @since 2.0.0
 */
@Component
public class QQLoginHandler implements LoginHandler<Serializable> {

    @Override
    public LoginType getLoginType() {
        return LoginType.QQ;

    }

    @Override
    public LoginResponse<String> handleLogin(LoginRequest request) {
        System.out.println("QQ登录：userId：{}" + request.getUserId());
        return LoginResponse.success("QQ登录成功" );
    }

}

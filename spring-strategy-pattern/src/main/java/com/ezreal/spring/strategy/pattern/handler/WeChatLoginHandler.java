package com.ezreal.spring.strategy.pattern.handler;

import com.ezreal.spring.strategy.pattern.enums.LoginType;
import com.ezreal.spring.strategy.pattern.model.LoginRequest;
import com.ezreal.spring.strategy.pattern.model.LoginResponse;
import org.springframework.stereotype.Component;

/**
 * Created on 2021/6/25.
 *
 * @author Ezreal
 * @since 2.0.0
 */
@Component
public class WeChatLoginHandler implements LoginHandler<String> {
    @Override
    public LoginType getLoginType() {
        return LoginType.WE_CHAT;
    }

    @Override
    public LoginResponse<String> handleLogin(LoginRequest request) {
        System.out.println("微信登录：userId：{}" + request.getUserId());
        String weChatName = getWeChatName(request);
        return LoginResponse.success("微信登录成功" + weChatName);

    }

    private String getWeChatName(LoginRequest request) {
        return "wupx";

    }
}

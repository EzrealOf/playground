package com.ezreal.spring.strategy.pattern.handler;

import com.ezreal.spring.strategy.pattern.enums.LoginType;
import com.ezreal.spring.strategy.pattern.model.LoginRequest;
import com.ezreal.spring.strategy.pattern.model.LoginResponse;

import java.io.Serializable;

/**
 * Created on 2021/6/25.
 *
 * @author Ezreal
 * @since 2.0.0
 */
public interface LoginHandler<T extends Serializable> {
    /**
     *      * 获取登录类型
     *      *
     *      * @return
     *      
     */
    LoginType getLoginType();

    /**
     *      * 登录
     *      *
     *      * @param request
     *      * @return
     *      
     */
    LoginResponse<String> handleLogin(LoginRequest request);
}

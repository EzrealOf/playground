package com.ezreal.spring.strategy.pattern.Serivce;

import com.ezreal.spring.strategy.pattern.model.LoginRequest;
import com.ezreal.spring.strategy.pattern.model.LoginResponse;

/**
 * Created on 2021/6/25.
 *
 * @author Ezreal
 * @since 2.0.0
 */
public interface LoginService {
    LoginResponse<String> login(LoginRequest request);
}

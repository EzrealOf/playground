package com.ezreal.spring.strategy.pattern.model;

import com.ezreal.spring.strategy.pattern.enums.LoginType;
import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2021/6/25.
 *
 * @author Ezreal
 * @since 2.0.0
 */
@Data
public class LoginRequest implements Serializable {

    private LoginType loginType;

    private Long userId;
}

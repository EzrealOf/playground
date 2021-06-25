package com.ezreal.spring.strategy.pattern.factory;

import com.ezreal.spring.strategy.pattern.enums.LoginType;
import com.ezreal.spring.strategy.pattern.handler.LoginHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Created on 2021/6/25.
 *
 * @author Ezreal
 * @since 2.0.0
 */
@Component
public class LoginHandlerFactory implements InitializingBean, ApplicationContextAware {

    private static final Map<LoginType, LoginHandler<Serializable>> LOGIN_TYPE_LOGIN_HANDLER_MAP = new EnumMap<>(LoginType.class);
    private ApplicationContext context;
    /**
     *      * 根据登录类型获取对应的处理器
     *      *
     *      * @param loginType 登录类型
     *      * @return 登录类型对应的处理器
     *      
     */
    public LoginHandler<Serializable> getHandler(LoginType type) {
        return LOGIN_TYPE_LOGIN_HANDLER_MAP.get(type);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
// 将 Spring 容器中所有的 LoginHandler 注册到 LOGIN_HANDLER_MAP
        context.getBeansOfType(LoginHandler.class).values().forEach(handler -> LOGIN_TYPE_LOGIN_HANDLER_MAP.put(handler.getLoginType(), handler));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }



}

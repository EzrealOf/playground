package com.ezreal.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 为了支持aop
 * 支持springEL，
 * 支持默认使用方法和参数hashcode
 * <p>
 * Created on 2022/3/21.
 *
 * @author lan
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AopLock {

    String expressions();

    String returnExpressions();

    Class<?> targetType() default String.class;

}

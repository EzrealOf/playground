package com.ezreal.reflect;

import java.lang.annotation.*;

/**
 * Created on 2021/6/15.
 *
 * @author Ezreal
 * @since 2.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DBTable {
    public String name() default "";
}
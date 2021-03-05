package com.ezreal.test;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Getter
public enum BaseEnums {

    /**
     *
     */
    CA(2, "CA"),
    US(2, "US"),
    EU(2, "EU"),
    EUUS(4, "EUUS"),;

    private Integer index;
    private String area;

    private BaseEnums(Integer index, String area) {
        this.index = index;
        this.area = area;
    }

    /**
     * 根据值获取对应枚举
     *
     * @param clazz
     * @param value
     * @param <T>
     * @return
     */
    public static <T> T getEnumByValue(Class<T> clazz, Integer value) {
        if (clazz == null || value == null || !clazz.isEnum()) {
            return null;
        }

        T[] objs = (T[]) clazz.getEnumConstants();
        for (int i = 0; i < objs.length; i++) {
            try {
                Method m = clazz.getMethod("getIndex");
                if (value.equals(m.invoke(objs[i]))) {
                    return objs[i];
                }
            } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static <T> T getEnumByDesc(Class<T> clazz, String desc) {
        if (clazz == null || StringUtils.isBlank(desc) || !clazz.isEnum()) {
            return null;
        }

        T[] objs = (T[]) clazz.getEnumConstants();
        for (int i = 0; i < objs.length; i++) {
            try {
                Method m = clazz.getMethod("getArea");
                if (desc.equals(m.invoke(objs[i]))) {
                    return objs[i];
                }
            } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static <T> T getEnumByContainsDesc(Class<T> clazz, String desc) {
        if (clazz == null || StringUtils.isBlank(desc) || !clazz.isEnum()) {
            return null;
        }

        T[] objs = (T[]) clazz.getEnumConstants();
        for (int i = 0; i < objs.length; i++) {
            try {
                Method m = clazz.getMethod("getArea");
                if (null != m.invoke(objs[i]) && desc.contains((String) m.invoke(objs[i]))) {
                    return objs[i];
                }
            } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
    public static <T> T getEnumByStartWithDesc(Class<T> clazz, String desc) {
        if (clazz == null || StringUtils.isBlank(desc) || !clazz.isEnum()) {
            return null;
        }

        T[] objs = (T[]) clazz.getEnumConstants();
        for (int i = 0; i < objs.length; i++) {
            try {
                Method m = clazz.getMethod("getArea");
                if (null != m.invoke(objs[i]) && desc.startsWith((String) m.invoke(objs[i]))) {
                    return objs[i];
                }
            } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BaseEnums value = BaseEnums.getEnumByValue(BaseEnums.class, 2);
        BaseEnums enums = BaseEnums.getEnumByDesc(BaseEnums.class, "EU");
        BaseEnums contains = BaseEnums.getEnumByContainsDesc(BaseEnums.class, "EU");
        BaseEnums startWith = BaseEnums.getEnumByStartWithDesc(BaseEnums.class, "EUUS");
        System.out.println(value.getArea());
        System.out.println(enums.getIndex());
        System.out.println(contains.getIndex());
        System.out.println(startWith.getIndex());
    }
}

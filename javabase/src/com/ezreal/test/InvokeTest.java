package com.ezreal.test;

import java.lang.reflect.Method;

/**
 * @author ezreal
 */
public class InvokeTest {

    public static void main(String[] args) {
        Dog dog = new Dog();

        try {
//            ins(Dog.class, dog, "say", null);
            ins(dog, "fei", "la");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void ins(Object dog, String methodName, String s) throws Exception {

        Method method = dog.getClass().getMethod(methodName, String.class );
        method.invoke(dog, s);
    }


}

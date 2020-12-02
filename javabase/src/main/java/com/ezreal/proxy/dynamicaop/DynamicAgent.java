package com.ezreal.proxy.dynamicaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ezreal
 */
public class DynamicAgent{

    private static class MyHandler implements InvocationHandler{
        private Object proxy;

        MyHandler(Object proxy){
            this.proxy = proxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>>>before invoking");
            Object invoke = method.invoke(this.proxy, args);
            System.out.println(">>>>after invoking");
            return invoke;
        }

    }
    public static Object agent(Class interfaceClazz, Object proxy){
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz},
                new MyHandler(proxy));
    }


}

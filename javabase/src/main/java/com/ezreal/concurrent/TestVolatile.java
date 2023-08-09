package com.ezreal.concurrent;

public class TestVolatile {

    private static volatile boolean flag = false;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (flag){
                        System.out.println("线程A在吃饭");
                        flag = false;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (!flag){
                        System.out.println("线程B在吃饭");
                        flag = true;
                    }
                }
            }
        }).start();



    }
}

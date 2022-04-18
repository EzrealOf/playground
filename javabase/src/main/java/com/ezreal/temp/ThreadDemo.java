package com.ezreal.temp;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;

public class ThreadDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                barrier.await();
                System.out.println("123");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(10000);
                barrier.await();
                System.out.println("324");
            }
        });
        thread.start();
        thread2.start();


    }
}

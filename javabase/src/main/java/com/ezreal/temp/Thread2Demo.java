package com.ezreal.temp;

import lombok.SneakyThrows;

import java.util.concurrent.Phaser;

public class Thread2Demo {

    @SneakyThrows
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                phaser.register();
                System.out.println("123");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(10000);
                phaser.register();
                System.out.println("324");
            }
        });
        thread.start();
        thread2.start();
        System.out.println(1);
        Thread.sleep(10000);

        phaser.arriveAndAwaitAdvance();


    }
}

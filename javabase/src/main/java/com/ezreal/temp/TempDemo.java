package com.ezreal.temp;

import lombok.SneakyThrows;
import org.apache.commons.lang3.ThreadUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TempDemo {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(1);



        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                latch.countDown();
                System.out.println("123");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                latch.countDown();
                System.out.println("324");
            }
        });


        thread.start();
        thread2.start();
        latch.countDown();

    }


}

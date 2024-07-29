package com.ezreal.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadExecutor {

    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        new ThreadPoolExecutor(processors, 20, 120L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1000));
    }
}


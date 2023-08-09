package com.ezreal.concurrent;

public class TestJoin {


    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程0开始执行了");
            }
        });
        thread.start();
        for (int i=0;i<10;i++){
            JoinThread jt=new JoinThread(thread,i);
            jt.start();
            thread=jt;
        }
    }

    static class JoinThread extends Thread{

        private  Thread thread;
        private int i;

        public JoinThread(Thread thread, int i){
            this.thread = thread;
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程"+ i + "执行了");
                sleep(1000);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

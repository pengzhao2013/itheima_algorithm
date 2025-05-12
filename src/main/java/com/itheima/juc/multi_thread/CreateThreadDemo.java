package com.itheima.juc.multi_thread;

/**
 * @author zpstart
 * @create 2025-04-18 20:18
 */
public class CreateThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new MyRunnable());
        thread.start();
        System.out.println("主线程");
    }
}

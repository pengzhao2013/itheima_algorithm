package com.itheima.juc.multi_thread;

/**
 * @author zpstart
 * @create 2025-04-18 20:21
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("线程Runnable");
    }
}

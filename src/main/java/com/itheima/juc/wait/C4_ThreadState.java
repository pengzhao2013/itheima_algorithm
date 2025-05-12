package com.itheima.juc.wait;

/**
 * @author zpstart
 * @create 2025-04-20 17:57
 */
public class C4_ThreadState {
    private static Object monitor = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            System.out.println(mainThread.getState());
        });
        thread.start();
        synchronized (monitor) {
            monitor.wait(2000);
        }
    }
}

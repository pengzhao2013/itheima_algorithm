package com.itheima.juc.wait;

/**
 * @author zpstart
 * @create 2025-04-20 17:48
 */
public class C4_Wait {
    private static Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            System.out.println("子线程执行");
            synchronized (monitor) {
                try {
                    monitor.wait();
//                    Thread.sleep(5000);
                    System.out.println("子线程继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000);

        synchronized (monitor) {
            System.out.println("主线程执行...");
            monitor.notify();
        }
    }
}

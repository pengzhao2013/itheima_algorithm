package com.itheima.juc.thread_safe;

/**
 * @author zpstart
 * @create 2025-04-20 11:28
 */
public class C4_InheritableThreadLocal {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("test");
        new Thread(() -> {
            String value = threadLocal.get();
            System.out.println("value:" + value);
        }).start();
        Thread.sleep(10000);
    }
}

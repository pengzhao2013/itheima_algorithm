package com.itheima.juc.thread_safe;

/**
 * @author zpstart
 * @create 2025-04-20 11:28
 */
public class C4_InheritableThreadLocal_2 {
    public static void main(String[] args) throws InterruptedException {
        InheritableThreadLocal<String> threadLocal =
                new InheritableThreadLocal<>();
        threadLocal.set("test");
        new Thread(() -> {
            String value = threadLocal.get();
            System.out.println("value:" + value);
        }).start();
        Thread.sleep(10000);
    }
}

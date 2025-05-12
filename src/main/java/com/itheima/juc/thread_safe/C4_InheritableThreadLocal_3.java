package com.itheima.juc.thread_safe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zpstart
 * @create 2025-04-20 11:37
 */
public class C4_InheritableThreadLocal_3 {
    public static void main(String[] args) {
        InheritableThreadLocal<String> threadLocal =
                new InheritableThreadLocal<>();
        threadLocal.set("test");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            if (i == 10) {
                threadLocal.set("test111");
            }
            executorService.execute(() -> {
                String value = threadLocal.get();
                System.out.println("value:" + value);
            });
        }
        executorService.shutdown();
    }
}

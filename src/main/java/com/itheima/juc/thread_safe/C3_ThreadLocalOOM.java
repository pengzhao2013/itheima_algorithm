package com.itheima.juc.thread_safe;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zpstart
 * @create 2025-04-20 10:47
 */
public class C3_ThreadLocalOOM {
    private static int j = 0;
    @Data
    static class User {
        String userName;
        Integer age = 0;

        public byte[] info = new byte[1024 * 1024]; // 1M
    }

    public static void main(String[] args) {
        ThreadLocal<User> userL = new ThreadLocal<>();
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 30; i++) {
            executorService.execute(() -> {
                userL.set(new User());
                System.out.println("第:" + (++j) + "个线程");
//                new User();
                userL.remove();
            });
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}

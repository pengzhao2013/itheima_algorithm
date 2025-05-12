package com.itheima.juc.thread_safe;

import lombok.Data;

/**
 * @author zpstart
 * @create 2025-04-20 10:25
 */
public class C2_LocalVariable {
    @Data
    static class User {
        String userName;
        Integer age = 0;
    }
    /**
     * ThreadLocal对象用完要手动remove 内存泄漏 User强引用 full GC 强引用数据不会垃圾回收掉
     */
    static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            userThreadLocal.set(new User());
            User user = userThreadLocal.get();
            for (int i = 0; i < 1000000; i++) {
                user.age++;
            }
            System.out.println(user.age);
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            userThreadLocal.set(new User());
            User user = userThreadLocal.get();
            for (int i = 0; i < 1000000; i++) {
                user.age++;
            }
            System.out.println(user.age);
        });
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

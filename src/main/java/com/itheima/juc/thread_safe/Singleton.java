package com.itheima.juc.thread_safe;

/**
 * @Author: zpstart
 * @Date: 2025-06-30 13:40
 * @Description: 单例模式
 */
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

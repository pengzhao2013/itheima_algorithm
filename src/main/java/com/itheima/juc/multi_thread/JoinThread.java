package com.itheima.juc.multi_thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zpstart
 * @create 2025-04-19 13:17
 */
@Slf4j
public class JoinThread {
    static int value = 1;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = 10;
            System.out.println("线程Runnable" + value);
        });

        t1.start(); // 异步
        System.out.println(t1.isAlive());
        t1.join(1000); // 主线程等待1s  等待线程结束 主线程进入WAITING / TIMED_WAITING状态
        // BLOCKED 等待锁

        System.out.println(t1.isAlive());
        System.out.println("主线程:" + value);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t1.isAlive());
    }
}

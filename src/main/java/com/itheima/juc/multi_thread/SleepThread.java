package com.itheima.juc.multi_thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zpstart
 * @create 2025-04-19 10:40
 */
@Slf4j
public class SleepThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(("t1" + "-" + Thread.currentThread().getName() + "开始睡眠"));
                TimeUnit.SECONDS.sleep(2);
                System.out.println(("t1" + "-" + Thread.currentThread().getName() + "结束睡眠"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(("t1" + "-" + Thread.currentThread().getName() + "完成睡眠"));
            while (true) {

            }
        });
        t1.setName("zptest-t1");
        t1.start();
        System.out.println((t1.isInterrupted() + ""));
        System.out.println((t1.isInterrupted() + ""));
        System.out.println((t1.isInterrupted() + ""));
    }
}

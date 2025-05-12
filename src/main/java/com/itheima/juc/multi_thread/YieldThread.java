package com.itheima.juc.multi_thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zpstart
 * @create 2025-04-19 11:03
 */
@Slf4j
public class YieldThread {
    static class Task1 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 200; i++) {
                log.info("A:" + i);
            }
        }
    }

    static class Task2 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
//                Thread.yield();
                log.info("B:" + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task2());
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        Thread thread2 = new Thread(new Task1());
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
    }
}

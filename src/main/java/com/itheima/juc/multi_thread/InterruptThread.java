package com.itheima.juc.multi_thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zpstart
 * @create 2025-04-19 11:39
 */
@Slf4j
public class InterruptThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000); // 不会一直占用CPU时间片 每隔1s将时间片清除 重新去获取时间片
                } catch (InterruptedException e) {
                    // 当出现InterruptedException 睡眠的时候中断 会清除中断标记 要继续设置标记为true，下面代码来判断 break
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                log.info(Thread.currentThread().isInterrupted() + "");
                if (Thread.interrupted()) {
                    // 获取中断状态并清除标记
                    log.info(Thread.currentThread().isInterrupted() + "");
                    break;
                }
                log.info("定时监控...");
            }
        });
        thread.start();
        // 只是通知线程需要中断，线程不会立马中断，只是给线程做个标记
        thread.interrupt();
        log.info(thread.isInterrupted() + "");
        log.info(thread.isInterrupted() + "");
    }
}

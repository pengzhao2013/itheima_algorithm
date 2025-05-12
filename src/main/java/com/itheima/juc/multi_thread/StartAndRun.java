package com.itheima.juc.multi_thread;


import lombok.extern.slf4j.Slf4j;

/**
 * @author zpstart
 * @create 2025-04-18 20:28
 */
@Slf4j
public class StartAndRun {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.info("2.子线程启动.." + "-" + Thread.currentThread().getName());
        });
        log.info("1.开始创建线程" + "-" + Thread.currentThread().getName());
//        t1.run();
        t1.setName("zptest-1");
        t1.start();
//        t1.start();
        log.info("3.主线程结束" + "-" + Thread.currentThread().getName());
    }
}

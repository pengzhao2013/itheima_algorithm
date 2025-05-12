package com.itheima.juc.thread_pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zpstart
 * @create 2025-04-19 16:19
 */
@Slf4j
public class C1_CreateThreadPool {
    public static void main(String[] args) {
        class Task implements Runnable {
            @Override
            public void run() {
                log.info("\t 办理业务");
            }
        }
        Task task = new Task();

        // 固定大小的线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 线程创建了5个就不会创建新的线程 5个一批5个一批
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 只有单个线程的线程池
//        ExecutorService threadPool = Executors.newCachedThreadPool(); // 可以动态扩容
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5); // 可以定时地执行
        try {
            int j = 1;
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(task);
                threadPool.schedule(task, 5, TimeUnit.SECONDS); // 延迟5s去执行
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 一定要关闭线程池 问题：线程池中线程一直占用系统资源 内存泄漏 线程没有关闭 一直占用
            // 主线程一直不会退出
            // 不会立马停止正在执行的线程 会等待执行完后才彻底关闭
//            threadPool.shutdown();
            // 不会立马停止正在执行的线程 只会等待正在执行的线程执行完后才彻底关闭
            threadPool.shutdownNow(); // 一次执行5个 只会等这五个执行结束
            try {
                // 等待线程池关闭 等待线程池中所有线程执行完毕
                threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadPool.isTerminated()); // 判断线程池是否真正“终止”了，并且代表线程也已经执行完毕
        }
    }
}

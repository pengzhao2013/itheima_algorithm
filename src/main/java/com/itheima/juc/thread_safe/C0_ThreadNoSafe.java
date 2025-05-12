package com.itheima.juc.thread_safe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zpstart
 * @create 2025-04-19 23:15
 */
public class C0_ThreadNoSafe {
    public static AtomicInteger stock = new AtomicInteger(1000000);

    static class StockRunnable implements Runnable {
        @Override
        public synchronized void run() {
            if (stock.get() > 0) {
//                System.out.println(Thread.currentThread().getName() + "stock:" + stock);
//                stock--; // 原子性：单一不可分割操作 stock--:分三步 拿到stock stock - 1 赋值给stock
                stock.decrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        StockRunnable stockRunnable = new StockRunnable();

        try {
            for (int i = 1; i <= 1000000; i++) {
                threadPool.execute(stockRunnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
            // 等待关闭
            threadPool.awaitTermination(1000, TimeUnit.SECONDS);
        }
        System.out.println("剩余库存: " + stock.get());
    }
}

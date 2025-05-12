package com.itheima.juc.cas;

import com.itheima.juc.thread_safe.C0_ThreadNoSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zpstart
 * @create 2025-04-20 16:53
 */
public class C4_CAS_OptimisticLock {
    public static AtomicInteger stock = new AtomicInteger(1000000);

    static class StockRunnable implements Runnable {
        @Override
        public void run() {
            if (stock.get() > 0) {
                int oldValue;
                int newValue;
                do {
                    oldValue = stock.get();
                    newValue = oldValue - 1;
                } while (!stock.compareAndSet(oldValue, newValue));
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

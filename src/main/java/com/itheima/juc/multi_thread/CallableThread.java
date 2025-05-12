package com.itheima.juc.multi_thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zpstart
 * @create 2025-04-19 15:23
 */
@Slf4j
public class CallableThread {
    public static void main(String[] args) {
//        new或lambda
//        class Task implements Callable<Integer> {
//            @Override
//            public Integer call() throws Exception {
//                return 5;
//            }
//        }
//        Task task = new Task();
//        FutureTask<Integer> future = new FutureTask<>(task);

        FutureTask<Integer> future = new FutureTask<>(() -> {
            log.info("子线程运行中");
            Thread.sleep(5000);
            return 5;
        });
        new Thread(future).start();
        try {
            Integer value = future.get();
            System.out.println("返回值" + value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

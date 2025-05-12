package com.itheima.juc.thread_pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author zpstart
 * @create 2025-04-19 18:17
 */
@Slf4j
public class C3_ExecuteVSSubmit {
    public static void main(String[] args)  {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //1.参数 execute只允许Runnable
        // submit callable
        // 2.返回值 execute void submit  Future
        // 3.异常 execute会在子线程中抛出异常，在主线程中捕捉不到
        // submit不会立马抛出异常，而是会将异常暂时存储起来，等Future.get()的时候才会抛出
        // 在主线程中可以捕捉到
//        try {
//            threadPool.execute(() -> {
//                int a = 1 / 0;
//                System.out.println("执行线程...");
//            });
//        } catch (Exception e) {
//            System.out.println("出现异常");
//            e.printStackTrace();
//        }

        try {
            Future future = threadPool.submit(() -> {
                System.out.println("执行线程...");
                int a = 1 / 0;
            });
            Object o = future.get();
        } catch (Exception e) {
            System.out.println("出现异常");
            e.printStackTrace();
        }
//        Future<Integer> future = threadPool.submit(() -> {
//            System.out.println("callable...");
//            return 6;
//        });
//        Integer integer = future.get();
//        System.out.println("future" + integer);
//        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
//            log.info("子线程运行中");
//            Thread.sleep(5000);
//            return 5;
//        });
//        threadPool.execute(futureTask);
//        Integer value = futureTask.get();
//        System.out.println("futureTask" + value);
    }
}

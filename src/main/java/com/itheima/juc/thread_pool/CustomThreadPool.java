package com.itheima.juc.thread_pool;

import java.util.concurrent.*;

/**
 * @author zpstart
 * @create 2025-04-19 16:13
 */
public class CustomThreadPool {
    public static void main(String[] args) {
        // keepAliveTime 非核心线程结束任务后空闲状态的存活时间 一旦空闲下来 销毁
        // 阻塞队列 超过最大线程数 之后 排队
        // 创建优先级： 核心线程数满了 -> 判断阻塞队列是否已满 队列放不下了 -> 判断最大线程数
        // 执行优先级： 核心线程数 -> 最大线程数 -> 阻塞队列
        ExecutorService threadPool = new ThreadPoolExecutor(
                10,
                20,
                0L, // 没有限制
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(), // 一般采用default
                new ThreadPoolExecutor.AbortPolicy()
        );
        class MyTask implements Runnable {
            int i = 0;
            public MyTask(int i) {
                this.i = i;
            }

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "程序员第" + i + "个项目");
                try {
                    Thread.sleep(3000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        int j = 1;
        try {
            for (int i = 1; i <= 20; i++) {
                MyTask myTask = new MyTask(i);
                threadPool.execute(myTask);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            threadPool.shutdown();
        }
        j = 2;
    }
}

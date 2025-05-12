package com.itheima.juc.wait;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zpstart
 * @create 2025-04-20 18:37
 */
public class C4_Shared_Queue {
    // 声明队列最大长度
    private int queueSize = 10;

    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    class producer extends Thread {
        // 保证生产者在整个过程中是线程安全的
        @Override
        public void run() {
            synchronized (queue) {
                // 1.判断当前队列长度
                if(queue.size() < queueSize) {
                    // 小于则生产消息
                    // 2.1添加一条消息
                    // 2.2唤醒消费者 有活了
                    queue.add(queue.size() + 1);
                    System.out.println("生产者往队列中加入一条消息,队列当前长度" + queue.size());

                    try {
                        // 模拟业务处理
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    queue.notify();
                } else {
                    // 3.如果大于 生产者wait()
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        queue.notify(); // 一旦出现异常，手动释放
                    }
                }
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            // 消费者持续工作
            while (true) {
                // 保证整个消费过程是线程安全的
                synchronized (queue) {
                    // 队列为空，睡眠
                    if (queue.isEmpty()) {
                        System.out.println("当前队列为空...");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            // 一旦出现异常，需要手动唤醒
                            queue.notify();
                        }
                    } else {
                        // 消费者工作 先拿出头部
                        Integer integer = queue.poll();
                        System.out.println("消费者从队列中消费一条消息" + integer +",队列当前长度" + queue.size());

                        // 唤醒生产者
                        queue.notify();

                        try {
                            // 模拟业务处理
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        C4_Shared_Queue test = new C4_Shared_Queue();
        Consumer consumer = test.new Consumer();
        consumer.start();

        Thread.sleep(2000);

        for (int i = 0; i < 10; i++) {
            producer producer = test.new producer();
            producer.start();
        }
    }
}

package com.itheima.juc.multi_thread;

/**
 * @author zpstart
 * @create 2025-04-19 13:59
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread d1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        d1.setDaemon(true); // 主线程结束 守护线程也会结束 区别：普通线程/用户线程
        d1.start();
        System.out.println("主线程结束");
    }
}

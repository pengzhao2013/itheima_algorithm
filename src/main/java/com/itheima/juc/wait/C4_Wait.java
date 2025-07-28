package com.itheima.juc.wait;

/**
 * @author zpstart
 * @create 2025-04-20 17:48
 */
public class C4_Wait {
    private static Object monitor = new Object();

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (monitor) {
                while (count <= 100) {
                    if ((count % 3) == 0) {
                        System.out.println("count Thread0=" + count++);
                        monitor.notifyAll();
                    } else {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "count Thread1").start();

        new Thread(() -> {
            synchronized (monitor) {
                while (count <= 100) {
                    if ((count % 3) == 1) {
                        System.out.println("count Thread1=" + count++);
                        monitor.notifyAll();
                    } else {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "count Thread2").start();

        new Thread(() -> {
            synchronized (monitor) {
                while (count <= 100) {
                    if ((count % 3) == 2) {
                        System.out.println("count Thread2=" + count++);
                        monitor.notifyAll();
                    } else {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "count Thread3").start();
    }
}

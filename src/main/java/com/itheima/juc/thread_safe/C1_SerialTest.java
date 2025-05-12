package com.itheima.juc.thread_safe;


/**
 * 有序性（指令重排）
 *
 * @author zpstart
 * @create 2025-04-20 10:07
 */
public class C1_SerialTest {
    static C1_SerialTest serialTest;

    static volatile Boolean isInit = false; // volatile加到不想指令重排的变量上 1.可见性 2.禁止指令重排

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            isInit = false;
            serialTest = null;

            Thread thread1 = new Thread(() -> {
//                synchronized (isInit) { // synchronized 变成串行
                    serialTest = new C1_SerialTest();
                    isInit = true;
//                }
            });
            Thread thread2 = new Thread(() -> {
//                synchronized (isInit) {
                    if (isInit) {
                        serialTest.doSomething();
                    }
//                }
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join(); // 保证两个线程都执行完再进行下次循环
        }
    }

    private void doSomething() {
        System.out.println("doSomething...");
    }
}

package com.itheima.juc.thread_safe;


/**
 * @author zpstart
 * @create 2025-04-20 9:44
 */
public class C1_VisibilityTest {
    static volatile Boolean always = true; // volatile 通过汇编lock前缀指令 锁定这块内存区域的缓存（缓存行锁定）
    // MESI 缓存一致性协议
    // 1.当前处理器缓存数据写回主内存
    // 2.引起其他cpu缓存该内存地址的数据无效
    // 3.提供内存屏障功能，使lock前后指令不能重排序

    static Boolean o = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (always) {
//                synchronized (always) {
//
//                }
//                System.out.println("执行中..."); // 里面也有synchronized
            }
        }).start();

        Thread.sleep(2000);
        always = false; // 只是改了当前线程工作内存中的值 不会同步到主内存 synchronized 可以在解锁时同步到主内存
    }
}

package com.itheima.juc.multi_thread;


/**
 * @author zpstart
 * @create 2025-04-19 14:16
 */
public class StateThread {
    public static void test1() {
        Thread t1 = new Thread(() -> {
            System.out.println("Theread1~~~");
        });
        System.out.println(t1.getState());
    }

    public static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Theread1开始执行");
        });
        t1.start();
        Thread.sleep(3000);
        System.out.println(t1.getState());
    }

    public static void test3() { // RUNNABLE
        Thread t1 = new Thread(() -> {
            System.out.println("Theread1~~~");
        });
        t1.start();
        System.out.println(t1.getState());
    }

    // blocked
    public static void test4() throws InterruptedException {
        class Table {
            public synchronized void use() {
                System.out.println(Thread.currentThread().getName() + "-使用桌子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-就餐结束");
            }
        }
        System.out.println(Thread.currentThread().getName());
        Table table = new Table();
        Thread student1 = new Thread(() -> {
            table.use();
        }, "s1");
        Thread student2 = new Thread(() -> {
            table.use();
        }, "s2");
        student1.start();
        Thread.sleep(3000);
        System.out.println(student1.getState());
        student2.start();
        Thread.sleep(5000);
        System.out.println(student2.getState());
    }

    // WAITING/TIMED_WAITING
    public static void test5() throws InterruptedException {
        class Table1 {
            public synchronized void use() throws InterruptedException {
                System.out.println(Thread.currentThread().getName() + "-使用桌子");
                System.out.println(Thread.currentThread().getName() + "-忘记点餐了");
//                wait(2000); // 任何对象都有的方法 TIME_WAITING
                wait(); // 任何对象都有的方法 WAITING  wait依赖synchronized 无参数 永久休眠
                System.out.println(Thread.currentThread().getName() + "-就餐结束");
            }
        }
        System.out.println(Thread.currentThread().getName());
        Table1 table = new Table1();
        Thread student1 = new Thread(() -> {
            try {
                table.use();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "s1");
        student1.start();
        Thread.sleep(1500);
        System.out.println(student1.getState());
    }


        public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }
}

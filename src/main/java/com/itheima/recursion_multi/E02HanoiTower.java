package com.itheima.recursion_multi;

import org.springframework.util.StopWatch;

import java.util.LinkedList;

/**
 * @author zpstart
 * @create 2023-08-06 10:08
 */
public class E02HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();

    static LinkedList<Integer> b = new LinkedList<>();

    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i); // LinkedList 往尾部 也就是柱子顶部添加圆盘
        }
    }

    /**
     *
     * @param n 圆盘个数
     * @param a 源
     * @param b 借
     * @param c 目标柱子
     */
    static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        move(n - 1, a, c, b); // 上面n-1个圆盘 a ->借助c ->  b
        c.addLast(a.removeLast());// 中间一步 最底下圆盘 a -> c
        print();
        move(n - 1, b ,a, c); // 上面n - 1个圆盘 b -> c
    }

    public static void main0(String[] args) {
        init(3);
        print();
        move(3, a, b ,c);
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int n = 1;
        init(n);
        print();
        stopWatch.start("n=1");
        move(n, a, b, c);
        stopWatch.stop();
        print();
        System.out.println(stopWatch.prettyPrint());
    }

    private static void print() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("----------------");
    }

}
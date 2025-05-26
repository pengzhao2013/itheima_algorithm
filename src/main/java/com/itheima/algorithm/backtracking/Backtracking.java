package com.itheima.algorithm.backtracking;

import java.util.LinkedList;

/**
 * @Author : zpstart
 * @Date: 2025-05-23 10:18
 */
public class Backtracking {
    public static void main(String[] args) {
        rec(1, new LinkedList<>());
    }
    static void rec(int n, LinkedList<String> list) {
        if (n == 3) {
            return;
        }
        System.out.println("before:" + list);
        list.push("a");
        rec(n + 1, list);
        list.pop();
        System.out.println("after:" + list);
    }
}

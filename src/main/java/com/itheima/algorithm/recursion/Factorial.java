package com.itheima.algorithm.recursion;

/**
 * @author zpstart
 * @create 2023-08-02 22:18
 */
public class Factorial {
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}

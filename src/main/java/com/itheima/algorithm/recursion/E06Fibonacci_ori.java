package com.itheima.algorithm.recursion;

/**
 * @author zpstart
 * @create 2025-04-30 22:00
 */
public class E06Fibonacci_ori {
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) { // 1 1 2 3 5 8
        System.out.println(fibonacci(6));
    }
}

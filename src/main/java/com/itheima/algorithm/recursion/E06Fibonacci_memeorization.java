package com.itheima.algorithm.recursion;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-04-30 22:06
 */
public class E06Fibonacci_memeorization {
    /**
     * 改进后O(n)
     * @author zpstart
     * @return void
     */
    public static void main(String[] args) {
        System.out.println(f(5));
    }

    public static int f(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = cache[1] = 1;
        return fibonacci(n, cache);
    }
    private static int fibonacci(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }
        cache[n] = fibonacci(n - 1, cache) +
                fibonacci(n - 2, cache);
        return cache[n];
    }
}

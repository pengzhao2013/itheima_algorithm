package com.itheima.algorithm.recursion;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2023-08-04 21:33
 */
public class E06Fibonacci {
    // fibonaci第n项递归次数：2*f(n+1) - 1
    // 时间复杂度： (1.618) ^ n 紧界
    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }

    /**
     * 记忆法改进(也称备忘录)
     * @author zpstart
     * @return int
     */
    public static int f(int n, int[] cache) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
        if (cache[n] != -1) {
            return cache[n];
        }
        int x = f(n - 1, cache);

        int y = f(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(40));
    }
}
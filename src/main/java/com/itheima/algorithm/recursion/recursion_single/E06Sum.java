package com.itheima.algorithm.recursion.recursion_single;

/**
 * @author zpstart
 * @create 2023-08-04 22:27
 */
public class E06Sum {
    public static long sum(int n) {
        if (n == 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

    public static long sum2(long n, long accumulator) {
        if (n == 1) {
            return accumulator + 1;
        }
        return sum2(n - 1, accumulator + n);
    }


    public static void main0(String[] args) {
        System.out.println(sum(15000));
    }

    public static void main(String[] args) {
        long accumulator = 0L;
        long n = 100;
        System.out.println(sum2(n, accumulator));
    }
}

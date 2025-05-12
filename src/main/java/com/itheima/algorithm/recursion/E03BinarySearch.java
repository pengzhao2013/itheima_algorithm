package com.itheima.algorithm.recursion;

/**
 * @author zpstart
 * @create 2023-08-02 22:37
 */
public class E03BinarySearch {
    public static int search(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }

    private static int f(int[] a, int target, int i, int j) {
        int m = (i + j) >>> 1;
        if (target < a[m]) {
            return f(a, target, i, m - 1);
        } else if (a[m] < target) {
            return f(a, target, m + 1, j);
        } else {
            return a[m];
        }
    }
}

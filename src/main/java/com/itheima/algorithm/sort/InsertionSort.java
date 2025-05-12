package com.itheima.algorithm.sort;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-04-15 16:01
 */
public class InsertionSort {
    private static void insertionRecursion(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        int t = a[low];
        int i = low - 1;
        while (i >= 0 && t < a[i]) {
            a[i + 1] = a[i];
            i--;
        }
        if (i + 1 != low) {
            a[i + 1] = t;
        }
        insertionRecursion(a, low + 1);
    }

    public static void sort(int[] a) {
        insertionRecursion(a, 1);
    }

    private static void insertionNotRecursion(int[] a) {
        for (int low = 1; low < a.length; low++) {
            int t = a[low];
            int i = low - 1;
            while (i >= 0 && t < a[i]) {
                a[i + 1] = a[i];
                i--;
            }
            if (i + 1 != low) {
                a[i + 1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 3, 7, 2, 5, 8, 1, 4};
        System.out.println(Arrays.toString(a));
//        sort(a);
        insertionNotRecursion(a);
        System.out.println(Arrays.toString(a));
    }
}

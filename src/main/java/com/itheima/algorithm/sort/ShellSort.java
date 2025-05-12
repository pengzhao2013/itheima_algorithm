package com.itheima.algorithm.sort;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-04-15 16:32
 */
public class ShellSort {
    public static void sort(int[] arr) {
        // a.length / 2 / 2  =1
        for (int gap = arr.length >> 1; gap >= 1; gap = gap >> 1) {
            for (int low = gap; low < arr.length; low += gap) {
                int t = arr[low];
                int i = low - gap;
                while (i >= 0 && t < arr[i]) {
                    arr[i + gap] = arr[i];
                    i -= gap;
                }
                if (i + gap != low) {
                    arr[i + gap] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 3, 7, 2, 5, 8, 1, 4};
        System.out.println(Arrays.toString(a));
//        sort(a);
//        insertionNotRecursion(a);
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

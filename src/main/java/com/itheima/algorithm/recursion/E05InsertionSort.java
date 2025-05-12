package com.itheima.algorithm.recursion;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2023-08-04 20:38
 */
public class E05InsertionSort {
    public static void sort(int[] a) {
        insertion(a, 1);
    }

    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        int temp = a[low];
        int i = low - 1;
        while (i >= 0 && a[i] > temp) {
            a[i + 1] = a[i]; // 空出插入位置
            i--;
        }

        // 找到插入位置
        if (i + 1 != low) {
            a[i + 1] = temp;
        }
        insertion(a, low + 1);
    }

    public static void main(String[] args) {
        int[] a = {2,5,6,9,8,5,6,4,1,2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
package com.itheima.algorithm.sort;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-04-14 20:48
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        // 选择轮数 arr.length - 1
        // 交换的索引位置arr.length - 1 每次递减
        for (int right = arr.length - 1; right > 0; right--) {
            // 假设最右侧是最大的
            int max = right;
            for (int i = 0; i < right - 1; i++) {
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            if (max != right) {
                swap(arr, max, right);
            }
        }
    }
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
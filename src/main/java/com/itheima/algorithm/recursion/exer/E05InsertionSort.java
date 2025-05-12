package com.itheima.algorithm.recursion.exer;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-04-28 20:02
 */
public class E05InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 2, 3, 9, 8, 7, 45, 23};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        insertionSort(arr, 1);
    }

    /**
     * low左边是排好序的
     * @author zpstart
     * @return void
     */
    private static void insertionSort(int[] arr, int low) {
        if (low == arr.length) {
            return;
        }
        int temp = arr[low];
        int i = low - 1;
        while (i >= 0 && arr[i] > temp) { // 一定不能写i >= 0 && arr[i] > arr[low]  arr[low]可能已经被 low - 1覆盖
            arr[i + 1] = arr[i];
            i--;
        }
        if (i + 1 != low) {
            arr[i + 1] = temp;
        }
        insertionSort(arr, low + 1);
    }
}

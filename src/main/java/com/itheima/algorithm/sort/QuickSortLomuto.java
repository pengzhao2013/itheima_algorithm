package com.itheima.algorithm.sort;

import java.util.Arrays;

/**
 * Lomuto分区 单边循环
 * @author zpstart
 * @create 2025-04-15 20:39
 */
public class QuickSortLomuto {
    public static void sort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    public static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right); // p-基准点元素索引
        quick(arr, left, p - 1);

        quick(arr, p + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        // 最右侧元素作为基准点
        // j找比基准点小的 i找比基准点大的 找到后交换
        // 最后基准点与i交换 i即为基准点最终索引
        int pv = arr[right]; // 基准点元素的值
        int i = left;
        int j = left;
        while (j < right) {
            if (arr[j] < pv) { // 找到比基准点小的了，没有找到大的
                if (i != j) {
                    swap(arr, i, j);
                }
                i++;
            }
            j++;
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {9, 3, 7, 2, 5, 8, 1, 4};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

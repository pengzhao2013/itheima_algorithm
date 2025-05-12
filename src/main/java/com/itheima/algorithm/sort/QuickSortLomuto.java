package com.itheima.algorithm.sort;

import java.util.Arrays;

/**
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
        int pv = arr[right];
        int i = left;
        int j = left;
        while (j < right) {
            if (arr[j] < pv) {
                if (i != j) {
                    swap(arr, i, j);
                }
                i++;
            }
            j++;
        }
        swap(arr, i ,right);
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

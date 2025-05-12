package com.itheima.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zpstart
 * @create 2025-04-15 21:17
 */
public class QuickSortHoarse {
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
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(arr, index, left);
        int pv = arr[left]; // 基准点
        int i = left;
        int j = right;
        while (i < j) {
            // j 右->左 找小
            while (i < j && arr[j] > pv) {
                j--;
            }
            while (i < j && arr[i] <= pv) {
                i++;
            }
            swap(arr, i ,j);
        }
        swap(arr, left, i);
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

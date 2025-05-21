package com.itheima.algorithm.sort.exer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zpstart
 * @create 2025-05-20 14:22
 */
public class QuickSortHoarse11 {
    public void sort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    private void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quick(arr, left, p - 1);
        quick(arr, p + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(arr, index, left);
        int pv = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] > pv) {
                j--;
            }
            while (i < j && arr[i] <= pv) {
                i++;
            }
            swap(arr, i ,j);
        }
        swap(arr, i, left);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

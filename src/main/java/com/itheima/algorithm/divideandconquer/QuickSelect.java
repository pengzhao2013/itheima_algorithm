package com.itheima.algorithm.divideandconquer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zpstart
 * @create 2025-05-18 18:59
 */
public class QuickSelect {
    static int quick(int[] array, int left, int right, int i) {
        int p = partition(array, left, right); // 基准点元素的位置
        if (i == p) {
            return array[p];
        }
        if (i < p) { // 到左边找
            return quick(array, left, p - 1, i);
        } else {
            return quick(array, p + 1, right, i);
        }

    }


    private static int partition(int[] arr, int left, int right) {
        // right - left + 1范围内元素个数
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left; // nextInt(3) [0,2]
        swap(arr, index, left);
        int pv = arr[left]; // 基准点的值
        int i = left;
        int j = right;
        while (i < j) {
            // j 右->左 找小
            while (i < j && arr[j] > pv) {
                j--;
            }
            // i 左->右 找大
            while (i < j && arr[i] <= pv) {
                i++;
            }
            // 找到后交换
            swap(arr, i ,j);
        }
        // 交换基准点元素与i
        swap(arr, left, i);
        return i;
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

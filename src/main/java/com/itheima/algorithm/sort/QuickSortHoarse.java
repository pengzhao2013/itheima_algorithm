package com.itheima.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 双边循环
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
        int p = partitionDuplicate(arr, left, right); // p-基准点元素索引
        quick(arr, left, p - 1);

        quick(arr, p + 1, right);
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

    /**
     * 优化大量重复元素的情况
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partitionDuplicate(int[] arr, int left, int right) {
        int pv = arr[left]; // 基准点的值
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && arr[i] < pv) { // >=了停下来
                i++;
            }
            while (i <= j && arr[j] > pv) {
                j--;
            }
            if (i <= j) {
                swap(arr, i ,j);
                i++;
                j--;
            }
        }
        swap(arr, j, left);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
//        int[] a = {9, 3, 7, 2, 5, 8, 1, 4};
        int[] a = {4, 2, 1, 3, 2, 1, 4};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

package com.itheima.algorithm.recursion.exer;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-04-27 22:55
 */
public class E04BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 9, 5, 3, 1, 2};
//        sort(arr);
        bubbleSortNotRecursion(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] a) {
        bubbleSort(a, a.length - 1);
    }

    /**
     * j:代表未排序区域右边界
     * @author zpstart
     * @return void
     */
    private static void bubbleSort(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                swap(a, i ,i + 1);
                x = i; // x:最后一次交换的位置 有序和无序的分界线
            }
        }
//        bubbleSort(a, j - 1);
        bubbleSort(a, x);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bubbleSortNotRecursion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j ,j + 1);
                }
            }
        }
    }
}

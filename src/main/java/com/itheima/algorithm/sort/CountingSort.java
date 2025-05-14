package com.itheima.algorithm.sort;

import java.util.Arrays;

/**
 * @Author : zpstart
 * @Date: 2025-05-14 15:38
 */
public class CountingSort {
    public static void CountingSortPositive(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        int[] count = new int[max + 1];
        for (int v : a) {
            count[v]++;
        }
//        System.out.println(Arrays.toString(count));
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            // i 原始数组元素 count[i] 该元素出现次数
            while (count[i] > 0) {
                a[k++] = i;
                count[i]--;
            }
        }
    }

    public static void sortContainNegative(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        int[] count = new int[max -min + 1];
        for (int v : a) {
            count[v - min]++;
        }
//        System.out.println(Arrays.toString(count));
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            // i + min 原始数组元素 count[i] 该元素出现次数
            while (count[i] > 0) {
                a[k++] = i + min;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 2, 2, 3, 6, 5};
        sortContainNegative(a);
        System.out.println(Arrays.toString(a));
    }
}

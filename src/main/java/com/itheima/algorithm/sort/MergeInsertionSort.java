package com.itheima.algorithm.sort;

import java.util.Arrays;

/**
 * @Author : zpstart
 * @Date: 2025-05-14 9:50
 */
public class MergeInsertionSort {

    private static void insertion(int[] a, int left, int right) {
        // 在某一范围内进行插入排序
        for (int low = left + 1; low <= right; low++) {
            int t = a[low];
            int i = low - 1;
            while (i >= left && t < a[i]) {
                a[i + 1] = a[i];
                i--;
            }
            if (i + 1 != low) {
                a[i + 1] = t;
            }
        }
    }

    /**
     * 功能描述
     * @author zpstart
     * @param a1
     * @param i 第一个有序范围
     * @param iEnd
     * @param j 第二个有序范围
     * @param jEnd
     * @param a2 临时数组 要和原始数组大小一致
     * @return void
     */
    public static void merge(int[] a1, int i, int iEnd, int j,
                             int jEnd, int[] a2) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            } else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
    }

    public static void sort(int[] a1) {
        int[] a2 = new int[a1.length]; // 临时数组给合并用的
        split(a1, 0, a1.length - 1, a2);
    }

    public static void split(int[] a1, int left, int right, int[] a2) {
        int[] array = Arrays.copyOfRange(a1, left, right + 1); // 为了打印
        System.out.println(Arrays.toString(array));
        // 2.治
        if (right - left <= 32) {
            // 插入排序
            insertion(a1, left, right);
            return;
        }
        // 1.分
        int m = (left + right) >>> 1;
        split(a1, left, m, a2);
        split(a1, m + 1, right, a2);
        merge(a1, left, m, m + 1, right, a2);
        System.arraycopy(a2, left, a1, left, right - left + 1); // merge后把a2再拷贝回a1
    }

    public static void main(String[] args) {
        int[] a = {9, 3, 7, 2, 5, 8, 1, 4};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

package com.itheima.datastructure.sorted_array;

import java.util.Arrays;

/**
  * leetcode 88题改
  * @author zpstart
  * @create 2023-08-28 18:41
 */
public class E01Merge2SortedArray {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 6, 2, 4, 10, 11};
        int[] a2 = new int[a1.length];
        merge(a1, 0, 2, 3, 6, a2);
        System.out.println(Arrays.toString(a2));
        System.arraycopy(a2, 0, a1, 0, a2.length);
        System.out.println(Arrays.toString(a1));
    }

    /**
     * 方法一 递归
     * a1 原始数组 a2 结果数组
     *
     * @author zpstart
     * @return void
     */
    public static void merge1(int[] a1, int i, int iEnd, int j, int jEnd,
                              int[] a2, int k) {
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
            return;
        }
        if (a1[i] < a1[j]) {
            a2[k] = a1[i];
            merge1(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        } else {
            a2[k] = a1[j];
            merge1(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
    }

    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd,
                             int[] a2) {
        int k = 0;
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
}

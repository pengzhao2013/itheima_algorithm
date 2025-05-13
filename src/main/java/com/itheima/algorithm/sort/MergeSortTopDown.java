package com.itheima.algorithm.sort;

import java.util.Arrays;

/**
 * BottomUp 非递归 自下而上
 * @author zpstart
 * @create 2025-05-13 21:00
 */
public class MergeSortTopDown {
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

    /**
     * width:每次合并时有序数组区间的宽度 取值依次是1,2,4
     * @author zpstart
     * @return void
     */
    public static void sort(int[] a1) {
        int n = a1.length;
        int[] a2 = new int[n]; // 临时数组给合并用的

        for (int width = 1; width < n; width *= 2) {
            // [left,right] 分别代表待合并区间的左右边界
            for (int left = 0; left < n; left += 2 * width) {
                int right = Math.min(n - 1, left + 2 * width - 1); // 本次右边界
//                System.out.printf("width %d [%d,%d]%n", width, left, right);
                int m = Math.min(left + width - 1, n - 1);
                merge(a1, left, m, m + 1, right, a2);
            }
            System.arraycopy(a2, 0, a1, 0, n);
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 3, 7, 2, 5, 8, 1, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

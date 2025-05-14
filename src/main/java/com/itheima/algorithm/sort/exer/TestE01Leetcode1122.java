package com.itheima.algorithm.sort.exer;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-05-14 19:27
 */
public class TestE01Leetcode1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] countArr = new int[1001];
        for (int i : arr1) {
            countArr[i]++;
        }
        int k = 0;
        for (int i : arr2) {
            while (countArr[i] > 0) {
                arr1[k++] = i;
                countArr[i]--;
            }
        }
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                arr1[k++] = i;
                countArr[i]--;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
}

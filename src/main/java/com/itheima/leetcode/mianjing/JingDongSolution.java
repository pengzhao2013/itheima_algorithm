package com.itheima.leetcode.mianjing;

/**
 * @Author: zpstart
 * @Date: 2025-07-24 14:08
 * @Description:
 */
public class JingDongSolution {
    public static int semiSearch(int[] array, int target) {
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            int middle = (i + j) >>> 1;
            if (array[middle] > target) {
                i = middle + 1;
            } else if (array[middle] < target) {
                j = middle - 1;
            } else {
                return middle;
            }
        }
        return -(i + 1);
    }
}

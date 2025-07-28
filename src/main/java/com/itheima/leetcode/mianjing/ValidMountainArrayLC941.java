package com.itheima.leetcode.mianjing;

/**
 * @Author: zpstart
 * @Date: 2025-07-27 15:23
 * @Description:
 */
public class ValidMountainArrayLC941 {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }
}

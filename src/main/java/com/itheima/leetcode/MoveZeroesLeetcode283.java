package com.itheima.leetcode;

import java.util.Arrays;

public class MoveZeroesLeetcode283 {
    static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {5, 1, 2, 3, 12};
        // 1 0 0 3 12 i = 1 j = 2
        // i = 1 j = 3
        // 1 3 0 0 12 i = 2 j = 4
        // 1 3 12 0 0 i = 3 j = 5
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

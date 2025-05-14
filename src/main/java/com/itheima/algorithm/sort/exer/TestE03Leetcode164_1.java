package com.itheima.algorithm.sort.exer;

import com.itheima.algorithm.sort.BucketSortGeneric;
import com.itheima.algorithm.sort.InsertionSort;
import com.itheima.datastructure.DynamicArray;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-05-14 20:53
 */
public class TestE03Leetcode164_1 {
    /**
     * 桶太多,超出内存限制
     * @author zpstart
     * @return int
     */
    public static int maximumGap(int[] nums) {
        // 1.处理特殊情况
        if (nums.length < 2) {
            return 0;
        }
        // 2.排序 inline ctrl+alt+n
        BucketSortGeneric.sort(nums, 1);
        // 3.寻找最大差值
        System.out.println(Arrays.toString(nums));
        int r = 0;
        for (int i = 1; i < nums.length; i++) {
            r = Math.max(r, nums[i] - nums[i - 1]);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 9};
        System.out.println(maximumGap(nums));
    }
}

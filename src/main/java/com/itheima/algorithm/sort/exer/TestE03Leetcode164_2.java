package com.itheima.algorithm.sort.exer;

import java.util.ArrayList;

/**
 * @author zpstart
 * @create 2025-05-14 21:07
 */
public class TestE03Leetcode164_2 {
    /**
     * 基数排序 限制桶的个数
     * @author zpstart
     * @return
     */
    public static int maximumGap(int[] nums) {
        // 1.处理特殊情况
        if (nums.length < 2) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        int m = 1;
        while (m <= max) {
            // 2.1.一轮基数排序
            for (int num : nums) {
                buckets[num / m % 10].add(num);
            }
            // 放回原数组
            int k = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer i : bucket) {
                    nums[k++] = i;
                }
                bucket.clear();
            }
//            System.out.println(Arrays.toString(nums));
            m = m * 10;
        }

        // 3.寻找最大差值
        int r = 0;
        for (int i = 1; i < nums.length; i++) {
            r = Math.max(r, nums[i] - nums[i - 1]);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {13, 100000, 26, 16};
        System.out.println(maximumGap(nums));
    }
}

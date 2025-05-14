package com.itheima.algorithm.sort.exer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zpstart
 * @create 2025-05-14 22:16
 */
public class TestE03Leetcode164_3 {
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
        // 2.排序 inline ctrl+alt+n
        int max = nums[0];
        int min = nums[0];
        for (int i1 = 1; i1 < nums.length; i1++) {
            if (nums[i1] > max) {
                max = nums[i1];
            }
            if (nums[i1] < min) {
                min = nums[i1];
            }
        }
        /**
         * 让桶个数等于数组长度 (max - min) / range + 1 = nums.length
         * @author zpstart
         * @return int
         */
        int range = Math.max((max -min) / (nums.length - 1), 1); // 防止除0
        // 2.1.准备桶
        ArrayList<Integer>[] buckets = new ArrayList[(max - min) / range + 1];
        for (int i1 = 0; i1 < buckets.length; i1++) {
            buckets[i1] = new ArrayList<>();
        }
        // 2.2 放入元素
        for (int age : nums) {
            buckets[(age - min) / range].add(age);
        }
        int k = 0;
        for (ArrayList<Integer> bucket : buckets) {
            // 2.3.排序桶内元素
            bucket.sort(Comparator.comparingInt(a -> a));
            System.out.println(bucket);
            // 2.4.把每个桶排序后的内容依次放入原始数组
            for (int v : bucket) {
                nums[k++] = v;
            }
        }


        // 3.寻找最大差值
        System.out.println(Arrays.toString(nums));
        int r = 0;
        for (int i = 1; i < nums.length; i++) {
            r = Math.max(r, nums[i] - nums[i - 1]);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 100000, 15, 13, 26};
        System.out.println(maximumGap(nums));
    }
}

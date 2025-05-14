package com.itheima.algorithm.sort.exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zpstart
 * @create 2025-05-14 22:43
 */
public class TestE03Leetcode164_4 {
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
         * 有空桶：(max - min) / range + 1 = nums.length + 1
         * @author zpstart
         * @return int
         */
        int range = Math.max((max -min) / nums.length, 1); // 防止除0
        // 2.1.准备桶
        Pair[] buckets = new Pair[(max - min) / range + 1];

        // 2.2 放入元素
        for (int v : nums) {
            int index = (v - min) / range;
            if (buckets[index] == null) {
                buckets[index] = new Pair();
            }
            buckets[index].add(v);
        }

//        for (Pair pair : buckets) {
//            System.out.println(pair);
//        }

        // 3.寻找最大差值
        int r = 0;
        int lastMax = buckets[0].max;
        for (int i = 1; i < buckets.length; i++) {
            Pair bucket = buckets[i];
            if (bucket != null) {
                r = Math.max(r, bucket.min - lastMax);
                lastMax = bucket.max;
            }
        }
        return r;
    }

    static class Pair {
        int max = 0;

        int min = 1000_000_000;

        void add(int v) { // 桶内最大最小值
            max = Math.max(max, v);
            min = Math.min(min, v);
        }

        @Override
        public String toString() {
            return "[" + max +
                    "," + min +
                    ']';
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 100000, 15, 13, 26};
        System.out.println(maximumGap(nums));
    }
}

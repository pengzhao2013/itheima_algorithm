package com.itheima.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zpstart
 * @Date: 2025-07-16 14:46
 * @Description:
 */
public class EraseOverlapIntervalsLc435 {
    // 下面代码为 Leetcode 435 题解
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int prev = 0;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return intervals.length - count;
    }
}

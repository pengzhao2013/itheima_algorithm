package com.itheima.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单调递减队列
 * @author zpstart
 * @create 2025-05-19 12:36
 */
public class SlidingWindowMaximumLeetcode239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 检查队列头部元素，超过滑动窗口范围要移除
            if (i >= k && nums[i - k] == queue.peek()) {
                queue.poll();
            }
            int num = nums[i];
            queue.offer(num);
            if (i >= k - 1) {
                list.add(queue.peek());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                maxSlidingWindow(new int[]{1, 3, -1, -3, -4, 5, 3, 6, 7}, 3))
        ); //[3, 3, 5, 5, 6, 7]
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7, 2, 4}, 2))); // [7, 4]
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3))); // [3, 3, 2, 5]
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4))); // [7, 7, 7, 7, 7]
    }
}

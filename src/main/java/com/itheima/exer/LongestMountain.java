package com.itheima.exer;

import java.util.ArrayList;

/**
 * @author zpstart
 * @create 2025-05-19 9:03
 */
public class LongestMountain {
    public int longestMountain(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n < 3) {
            return 0;
        }
        int maxLength = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1) && nums.get(i) > nums.get(i + 1)) {
                int left = i - 1;
                int right = i + 1;
                while (left > 0 && nums.get(left) > nums.get(left - 1)) {
                    left--;
                }

                while (right < n - 1 && nums.get(right) > nums.get(right + 1)) {
                   right++;
                }
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}

package com.itheima.datastructure.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : zpstart
 * @Date: 2025-05-13 11:14
 */
public class E05Leetcode136 {
    public int singleNumber0(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.toArray(new Integer[0])[0];
    }

    // x ^ y ^ y = x 异或交换律
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}

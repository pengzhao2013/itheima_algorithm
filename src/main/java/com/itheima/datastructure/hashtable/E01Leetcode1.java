package com.itheima.datastructure.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zpstart
 * @create 2025-05-12 20:15
 */
public class E01Leetcode1 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                return new int[] {numMap.get(nums[i]), i};
            }
            numMap.put(target - nums[i], i);
        }
        return null;
    }
}

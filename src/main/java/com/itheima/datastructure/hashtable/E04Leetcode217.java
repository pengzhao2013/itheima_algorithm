package com.itheima.datastructure.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : zpstart
 * @Date: 2025-05-13 11:00
 */
public class E04Leetcode217 {
    public boolean containsDuplicate3(int[] nums) {
        Map<Integer, Object> map = new HashMap<>(nums.length * 2);
        Object object = new Object();
        for (Integer num : nums) {
            Object put = map.put(num, object); // put之前的值
            if (put != null) {
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, num);
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}

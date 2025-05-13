package com.itheima.datastructure.hashtable;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zpstart
 * @create 2025-05-12 21:12
 */
public class E02Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int end;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                begin = Math.max(map.get(c) + 1, begin);
                map.put(c, i);
            } else {
                map.put(c, i);
            }
            end = i;
            max = Math.max(max, end - begin + 1);
        }
        return max;
    }
}

package com.itheima.datastructure.hashtable;

/**
 * @Author : zpstart
 * @Date: 2025-05-13 12:15
 */
public class E07Leetcode387 {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            arr[ch -97]++;
        }
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (arr[ch - 97] == 1) {
                return i;
            }
        }
        return -1;
    }

}

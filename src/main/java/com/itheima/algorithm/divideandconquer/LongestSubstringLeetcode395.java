package com.itheima.algorithm.divideandconquer;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-05-18 20:58
 */
public class LongestSubstringLeetcode395 {
    static int longestSubstring(String s, int k) {
        // 落选情况
        if (s.length() < k) {
            return 0;
        }
        int[] counts = new int[26];

        char[] chars = s.toCharArray();

        for (char c : chars) {
            counts[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int count = counts[c - 'a']; // i字符出现次数
            if (count > 0 && count < k) {
                int j = i + 1;
                while (j < s.length() && counts[chars[j] - 'a'] < k) {// j字符出现次数
                    j++;
                }
                System.out.println(s.substring(0, i) + "\t" + s.substring(j));
                return Integer.max(longestSubstring(s.substring(0, i), k),
                longestSubstring(s.substring(j), k)); // 只切分一次,不会出现重复切分
            }
        }
//        System.out.println(Arrays.toString(counts));

        // 入选
        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaaccbbb", 3));
    }
}

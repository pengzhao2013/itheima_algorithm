package com.itheima.leetcode;

/**
 * 字符串匹配
 * @author zpstart
 * @create 2025-05-19 14:07
 */
public class StrStrLeetcode28 {
    static int strStr(String str1, String str2) {
        char[] origin = str1.toCharArray();
        char[] pattern = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i <= origin.length - pattern.length) {
            // 每次循环开始时j重置为0
            for (j = 0; j < pattern.length; j++) {
                if (pattern[j] != origin[i + j]) {
                    break;
                }
            }
            if (j == pattern.length) {
                return i;
            }
            i++;
        }
        return -1;
    }
}

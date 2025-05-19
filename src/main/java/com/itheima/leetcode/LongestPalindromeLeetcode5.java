package com.itheima.leetcode;


/**
 * 最长回文子串
 * @author zpstart
 * @create 2025-05-19 16:29
 */
public class LongestPalindromeLeetcode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("bccbcbabcbafa"));
    }

    static String longestPalindrome(String s) {
        left = 0;
        right = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            extend(chars, i, i); // 一个字符作为中心点
            extend(chars, i, i + 1); // 两个字符作为中心点
        }
        return new String(chars, left, right - left + 1);
    }

    static int left;

    static int right;

    static void extend(char[] chars, int i, int j) {
        while (i >= 0 && j < chars.length &&
                chars[i] == chars[j]) {
            i--;
            j++;
        }
        // 此时i j不是回文了
        i++;
        j--;
        if (j - i > right - left) {
            left = i;
            right = j;
        }
    }
}

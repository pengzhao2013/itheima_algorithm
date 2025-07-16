package com.itheima.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * 两个字符串的删除操作
 * @author zpstart
 * @create 2025-05-18 9:07
 */
public class RemainLCSubsequencelc583 {
    /**
     * 要当成公共子序列来处理
     * @author zpstart
     * @return void
     */
    public static void main(String[] args) {
        RemainLCSubsequencelc583 code = new RemainLCSubsequencelc583();
        System.out.println(code.minDistance("leetcode", "etco")); // 结果4  8-4 + 4-4 = 4
//        System.out.println(code.minDistance("eat", "sea"));       // 结果2  3-2 + 3-2 = 2
//        System.out.println(code.minDistance("park", "spake"));    // 结果3  4-3 + 5-3 = 3
    }

    public int minDistance(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }

    static void print(int[][] dp, String a, String b) {
        System.out.println("-".repeat(23));
        Object[] array = a.chars().mapToObj(i -> String.valueOf((char) i)).toArray();
        System.out.printf("     " + "%2s ".repeat(a.length()) + "%n", array);
        System.out.printf("     " + "%2s ".repeat(a.length()) + "%n", a.chars().mapToObj(i -> "0").toArray());
        for (int i = 0; i < b.length(); i++) {
            int[] d = dp[i + 1];
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(b.charAt(i) + " " + "%2d ".repeat(d.length) + "%n", array);
        }
    }
}

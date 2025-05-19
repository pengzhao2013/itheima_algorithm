package com.itheima.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-05-18 10:17
 */
public class CatalanLc96 {
    public static void main(String[] args) {
        System.out.println(catalan(6));
    }

    static int catalan(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int j = 2; j < n + 1; j++) {
            for (int i = 0; i < j; i++) { // 求第j个Catalan数
                // 对第j个Catalan数做内层拆分
//                System.out.printf("(%d,%d)\t", i, j - 1 -i);
                dp[j] += dp[i] * dp[j - 1 -i];
            }
//            System.out.println();
//            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}

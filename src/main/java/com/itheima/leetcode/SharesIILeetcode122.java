package com.itheima.leetcode;

/**
 * @Author : zpstart
 * @Date: 2025-05-27 10:00
 */
public class SharesIILeetcode122 {
    static int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int sum = 0;
        while (j < prices.length) {
            if (prices[j] - prices[i] > 0) {
                sum += prices[j] - prices[i];
            }
            i++;
            j++; // 有利润没利润i j 都++
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{9, 3, 12, 1, 2, 3})); // 11
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 7
    }
}

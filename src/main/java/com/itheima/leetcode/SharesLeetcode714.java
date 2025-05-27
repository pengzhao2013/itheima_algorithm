package com.itheima.leetcode;

/**
 * <h3>某一天买入股票，未来任意一天卖出，只能卖了再买，但可以买卖多次，每笔交易有手续费，求最大利润</h3>
 * @Author : zpstart
 * @Date: 2025-05-27 11:16
 */
public class SharesLeetcode714 {
    /*
    fee：2
        0       1           2           3           4       5
        1       3           2           8           4       9
 买     -1     等-1 √       等-1 √       等-1 √      -1       等1 √
               买-3         买-2        买-8        买1 √     买-4
 卖     0      等0  √        等0  √      等0          等5 √    等5
               卖0          卖-1         卖5 √        卖1     卖8 √


     */
    static int maxProfit2(int[] prices, int fee) {
        // _buy _sell buy sell
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            // 延续上一天买的利润或上一天卖的利润-今天买的价格
            buy = Math.max(buy, sell - price);
            // 在上次买的利润基础上卖
            sell = Math.max(sell, buy + price - fee);
        }
        return sell;
    }

    static int maxProfit1(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 延续上一天买的利润或上一天卖的利润-今天买的价格
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            // 在上次买的利润基础上卖
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        // 两次交易的情况
        System.out.println(maxProfit2(new int[]{1, 3, 2, 8, 4, 9}, 2)); // 8
        System.out.println(maxProfit2(new int[]{1, 3, 7, 2, 18, 3}, 3)); // 16
        System.out.println(maxProfit2(new int[]{2, 1, 4, 4, 2, 3, 2, 5, 1, 2}, 1)); // 4
        System.out.println(maxProfit2(new int[]{9, 3, 12, 1, 2, 3}, 1)); // 9

        // 一次交易的情况
        System.out.println(maxProfit2(new int[]{1, 3, 7, 5, 10, 3}, 3)); // 6
        System.out.println(maxProfit2(new int[]{1, 3, 7, 5, 10, 11, 3}, 3)); // 7

    }
}

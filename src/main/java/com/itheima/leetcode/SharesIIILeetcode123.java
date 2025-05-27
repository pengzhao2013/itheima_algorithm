package com.itheima.leetcode;

/**
 * <h3>某一天买入股票，未来任意一天卖出，只能先卖再买，最多买卖两次，求最大利润</h3>
 * @Author : zpstart
 * @Date: 2025-05-27 15:02
 */
public class SharesIIILeetcode123 {
    /*
    第一次买 不依赖之前状态，以当日价格买入
    第一次卖，依赖于昨天第一次买 + 当日价格

    第二次买，依赖于昨天第一次卖 - 当日价格
    第二次卖，依赖于昨天第二次买 + 当日价格
    */
    static int maxProfit0(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int price : prices) {
            // 当日价格 不依赖于前面sell1的状态 以当日价格买入
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);

            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }

    static int maxProfit(int[] prices) {
        int[] buy1 = new int[prices.length];
        int[] sell1 = new int[prices.length];

        int[] buy2 = new int[prices.length];
        int[] sell2 = new int[prices.length];

        buy1[0] = -prices[0];
        sell1[0] = 0;
        buy2[0] = -prices[0];
        sell2[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1[i] = Math.max(buy1[i - 1], -prices[i]);
            sell1[i] = Math.max(sell1[i - 1], buy1[i - 1] + prices[i]);

            buy2[i] = Math.max(buy2[i - 1], sell1[i - 1] - prices[i]);
            sell2[i] = Math.max(sell2[i - 1], buy2[i - 1] + prices[i]);
        }
        return sell2[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 6
    }
}

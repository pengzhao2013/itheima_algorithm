package com.itheima.algorithm.exhaustion;

/**
 * @author zpstart
 * @create 2025-05-16 20:22
 */
public class Leetcode322Greedy {
    public int coinChange(int[] coins, int amount) {
        // 每次循环找到当前最优解
        int remainder = amount;
        int count = 0;
        for (int coin : coins) {
            while (remainder > coin) {
                remainder -= coin;
                count++;
            }
            if (remainder == coin) {
                remainder = 0;
                count++;
                break;
            }
        }
        if (remainder > 0) {
            return -1;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        Leetcode322Greedy leetcode322Greedy = new Leetcode322Greedy();
//        System.out.println(leetcode322Greedy.coinChange(new int[]{5, 2, 1}, 18));
        System.out.println(leetcode322Greedy.coinChange(new int[]{2}, 3));
    }
}

package com.itheima.algorithm.exhaustion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 零钱兑换 II - 穷举解法
 * @Author : zpstart
 * @Date: 2025-05-16 15:58
 */
public class Leetcode518 {
    /**
     * 暴力递归
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return rec(0, coins, amount, new LinkedList<>(), true);
    }

    public int rec(int index, int[] coins, int remainder, LinkedList<Integer> stack,
                   boolean first) {
        if (!first) {
            stack.push(coins[index]);
        }
        // 情况1:剩余金额<0
        // 情况2:剩余金额>0
        // 情况3:剩余金额==0
        int count = 0;
        if (remainder < 0) {
            print("无解：", stack);
        } else if (remainder == 0) {
            print("有解：", stack);
            count = 1;
        } else {
            for (int i = index; i < coins.length; i++) {
                count += rec(i, coins, remainder - coins[i], stack, false);
            }
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
        return count;
    }

    private static void print(String prompt, LinkedList<Integer> stack) {
        ArrayList<Integer> print = new ArrayList<>();
        ListIterator<Integer> iterator = stack.listIterator(stack.size());
        while (iterator.hasPrevious()) {
            print.add(iterator.previous());
        }
        System.out.println(prompt + print);
    }

    public static void main(String[] args) {
        Leetcode518 leetcode518 = new Leetcode518();
        int count = leetcode518.coinChange(new int[]{5, 2, 1}, 5);
        System.out.println(count);
    }
}

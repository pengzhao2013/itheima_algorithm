package com.itheima.algorithm.exhaustion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 至少需要几个硬币
 * @Author : zpstart
 * @Date: 2025-05-16 17:55
 */
public class Leetcode322 {
    static int min = -1;

    /**
     * 暴力递归
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        rec(0, coins, amount, new AtomicInteger(-1), new LinkedList<>(), true);
        return min;
    }

    public void rec(int index, int[] coins, int remainder, AtomicInteger count, LinkedList<Integer> stack,
                   boolean first) {
        if (!first) {
            stack.push(coins[index]);
        }
        count.incrementAndGet();
        // 情况1:剩余金额<0
        // 情况2:剩余金额>0
        // 情况3:剩余金额==0
        if (remainder < 0) {
//            print("无解：", stack);
        } else if (remainder == 0) {
            if (min == -1) {
                min = count.get();
            } else {
                min = Math.min(min, count.get());
            }
            print("有解：", stack);
        } else {
            for (int i = index; i < coins.length; i++) {
                rec(i, coins, remainder - coins[i], count, stack, false);
            }
        }
        count.decrementAndGet();
        if (!stack.isEmpty()) {
            stack.pop();
        }
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
        Leetcode322 leetcode322= new Leetcode322();
        int count = leetcode322.coinChange(new int[]{5, 2, 1}, 18);
        System.out.println(count);
    }
}

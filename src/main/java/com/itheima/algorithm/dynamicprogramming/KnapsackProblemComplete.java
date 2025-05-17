package com.itheima.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author zpstart
 * @create 2025-05-17 17:28
 */
public class KnapsackProblemComplete {
    static class Item {
        int index;
        String name;
        int weight;
        int value;

        public Item(int index, String name, int weight, int value) {
            this.index = index;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item(" + name + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1, "青铜", 2, 3),    // c
                new Item(2, "白银", 3, 4),    // s
                new Item(3, "黄金", 4, 7),    // a
        };
        System.out.println(select0(items, 6));
    }

    /*
            0   1   2   3   4   5   6
        1   0   0   c   c   cc  cc  ccc     青铜 重2 第i行只放item[i]
        2   0   0   c   s   cc  sc  ccc     白银 重3
        3   0   0   c   s   a   a   ac      黄金 重4

        if(放得下) {
            dp[i][j] = max(dp[i-1][j], dp[i][j-item.weight] + item.value)
        } else {
            dp[i][j] = dp[i-1][j]
        }
     */
    private static int select(Item[] items, int total) {
        int[][] dp = new int[items.length][total + 1];
        Item item0 = items[0];
        for (int j = 0; j < total + 1; j++) {
            if (j >= item0.weight) { // 放得下
                dp[0][j] = dp[0][j - item0.weight] + item0.value;
            }
        }
        print(dp);
        for (int i = 1; i < items.length; i++) {
            Item item = items[i];
            // j从0开始,是方便数组索引1,2,3...正好表示总金额/总重量
            for (int j = 0; j < total + 1; j++) {
                int x = dp[i - 1][j]; // 上次最大价值
                if (j >= item.weight) {
                    // 背包放当前物品后剩余能装的最大价值 + 当前物品价值
                    dp[i][j] = Integer.max(x, item.value + dp[i][j - item.weight]);
                } else {
                    dp[i][j] = x;
                }
            }
            print(dp);
        }
        return dp[dp.length - 1][total];
    }

    private static int select0(Item[] items, int total) {
        int[] dp = new int[total + 1];
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            for (int j = 0; j < total + 1; j++) {
                // dp[j]上次最大价值
                if (j >= item.weight) {
                    // 背包放当前物品后剩余能装的最大价值 + 当前物品价值
                    dp[j] = Integer.max(dp[j], item.value + dp[j - item.weight]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[total];
    }

    static void print(int[][] dp) {
        System.out.println("   " + "-".repeat(63));
        Object[] array = IntStream.range(0, dp[0].length + 1).boxed().toArray();
        System.out.printf(("%5d ".repeat(dp[0].length)) + "%n", array);
        for (int[] d : dp) {
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(("%5d ".repeat(d.length)) + "%n", array);
        }
    }
}

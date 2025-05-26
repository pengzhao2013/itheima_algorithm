package com.itheima.algorithm.backtracking;

import java.util.Arrays;

/**
 * N皇后:回溯
 * @Author : zpstart
 * @Date: 2025-05-23 16:50
 */
public class NQueenLeetcode51 {
    static int count = 0;

    public static void main(String[] args) {
        int n = 8;
        // 要点1:数组保存每一步状态
        boolean[] ca = new boolean[n];// 记录列冲突
        boolean[] cb = new boolean[2 * n - 1];// 左斜线冲突
        boolean[] cc = new boolean[2 * n - 1];// 右斜线冲突
        // n - 1 - (i - j)
        char[][] table = new char[n][n]; // "." "Q"
        for (char[] t : table) {
            Arrays.fill(t, '.');
        }
        dfs(0, n, table, ca, cb, cc);

    }
    static void dfs(int i, int n, char[][] table, boolean[] ca,
                    boolean[] cb, boolean[] cc) {
        if (i == n) {
            System.out.println(++count);
            System.out.println("-------------");
            for (char[] t : table) {
                System.out.println(new String(t));
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            // 避免不必要的递归 剪枝的操作
            if (ca[j] || cb[i + j] || cc[n - 1 - (i - j)]) {
                continue;
            }
            table[i][j] = 'Q';
            ca[j] = cb[i + j] = cc[n - 1 - (i - j)] = true;
            dfs(i + 1, n, table, ca, cb, cc); // i + 1行再放入
            table[i][j] = '.';
            ca[j] = cb[i + j] = cc[n - 1 - (i - j)] = false;
        }
    }
}

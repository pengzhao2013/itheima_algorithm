package com.itheima.recursion_multi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zpstart
 * @create 2023-08-22 19:51
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            int n = in.nextInt();// 注意 while 处理多个 case
            int k = in.nextInt();
            int d = in.nextInt();
            int[] ability = new int[n];
            for (int i = 0; i < n; i++) {
                ability[i] = in.nextInt();
            }
            int curNum = 0;
            int curIndex = 0;
            int preSumValue = 1;
            int preIndex = -1;
            long[][] maxProduct = new long[n][k];
            long[][] minProduct = new long[n][k];
            for (int i = 0; i < n; i++) {
                maxProduct[i][0] = ability[i];
                minProduct[i][0] = ability[i];
            }

            long max = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < k; j++) {
                    for (int p = i - 1; p >= Math.max(i - d, 0); p--) {
                        maxProduct[i][j] =
                                Math.max(maxProduct[i][j], maxProduct[p][j - 1] * ability[i]);
                        maxProduct[i][j] =
                                Math.max(maxProduct[i][j], minProduct[p][j - 1] * ability[i]);
                        minProduct[i][j] =
                                Math.min(minProduct[i][j], minProduct[p][j - 1] * ability[i]);
                        minProduct[i][j] =
                                Math.min(minProduct[i][j], maxProduct[p][j - 1] * ability[i]);
                    }
                }
                max = Math.max(max, maxProduct[i][k - 1]);
            }
            System.out.println(max);
        }
    }
}

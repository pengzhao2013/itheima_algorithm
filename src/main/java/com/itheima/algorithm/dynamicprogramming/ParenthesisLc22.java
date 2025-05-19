package com.itheima.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-18 11:19
 */
public class ParenthesisLc22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>(List.of(""));
        dp[1] = new ArrayList<>(List.of("()"));
        for (int j = 2; j < n + 1; j++) {
            dp[j] = new ArrayList<>();
            for (int i = 0; i < j; i++) { // 求第j个Catalan数
                // 对第j个Catalan数做内层拆分
//                System.out.printf("(%d,%d)\t", i, j - 1 -i);
                // i 对应的集合是内层要嵌套的括号, j - 1 - i 对应的集合是平级要拼接的括号
                for (String k1 : dp[i]) {
                    for (String k2 : dp[j - 1 - i]) {
                        dp[j].add("(" + k1 + ")" + k2);
                    }
                }
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }
    public static void main(String[] args) {
        ParenthesisLc22 code = new ParenthesisLc22();
        System.out.println(code.generateParenthesis(3));
    }
}

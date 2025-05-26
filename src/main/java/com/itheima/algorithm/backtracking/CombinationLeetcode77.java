package com.itheima.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : zpstart
 * @Date: 2025-05-23 11:24
 */
public class CombinationLeetcode77 {
    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, n, k, new LinkedList<>(), result);
        return result;
    }

    // start 起始开始数字
    static void dfs(int start, int n, int k, LinkedList<Integer> stack,
                    List<List<Integer>> result) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= n; i++) {
            // k - stack.size 还差几个能凑满
            // n - i + 1 还剩几个备用数字
            if (k - stack.size() > n - i + 1) {
                continue; // 剪枝
            }
            stack.push(i);
            dfs(i + 1, n, k, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4, 3);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

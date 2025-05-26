package com.itheima.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : zpstart
 * @Date: 2025-05-23 16:04
 */
public class CombinationLeetcode216_teacher {
    static List<List<Integer>> combine(int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, target, k, new LinkedList<>(), result);
        return result;
    }

    static int count = 0;

    // start 起始开始数字
    static void dfs(int start, int target, int k, LinkedList<Integer> stack,
                    List<List<Integer>> result) {
//        System.out.println(stack);
        count++;
        if (stack.size() == k && target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (target < i) {
                return;
            }
            // k - stack.size 还差几个能凑满
            // target - i + 1 还剩几个备用数字
//            if (k - stack.size() > 9 - i + 1) {
//                continue; // 剪枝
//            }
            if (stack.size() == k) {
                return;
            }
            stack.push(i);
            dfs(i + 1, target - i, k, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(2, 18);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        System.out.println(count);
    }
}

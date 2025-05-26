package com.itheima.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : zpstart
 * @Date: 2025-05-23 14:40
 */
public class CombinationLeetcode39 {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, target, new LinkedList<>(), result);
        return result;
    }

    static void dfs(int start, int[] candidates, int target,
                    LinkedList<Integer> stack, List<List<Integer>> result) {
//        if (target < 0) {// 不会出现
//            return;
//        }
        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                continue;
            }
            stack.push(candidate);
            dfs(i, candidates, target - candidate, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}

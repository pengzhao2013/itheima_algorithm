package com.itheima.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : zpstart
 * @Date: 2025-05-23 15:49
 */
public class CombinationLeetcode216 {
    static List<List<Integer>> combinationSum2(int k, int target) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, k, target, new LinkedList<>(), result);
        return result;
    }

    static void dfs(int start, int[] candidates, int k, int target,
                    LinkedList<Integer> stack, List<List<Integer>> result) {
//        if (target < 0) {// 不会出现
//            return;
//        }
        if (target == 0 && stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                return;
            }
            stack.push(candidate);
            dfs(i + 1, candidates, k, target - candidate, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum2(3, 9);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}

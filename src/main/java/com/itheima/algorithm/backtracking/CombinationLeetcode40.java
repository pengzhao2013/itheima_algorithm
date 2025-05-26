package com.itheima.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : zpstart
 * @Date: 2025-05-23 15:19
 */
public class CombinationLeetcode40 {
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, new boolean[candidates.length], target, new LinkedList<>(), result);
        return result;
    }

    static void dfs(int start, int[] candidates, boolean[] visited, int target,
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
            if (i > 0 && candidate == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            stack.push(candidate);
            dfs(i + 1, candidates, visited, target - candidate, stack, result);
            stack.pop();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}

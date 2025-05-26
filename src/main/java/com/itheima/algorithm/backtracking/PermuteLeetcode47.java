package com.itheima.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : zpstart
 * @Date: 2025-05-23 11:13
 */
public class PermuteLeetcode47 {
    static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    static void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack,
                    List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            //result.add(stack); // stack下次会清空
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 前面一个还没有访问过的情况不可以 先固定1再固定1`不能反过来 剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                stack.push(nums[i]);
                visited[i] = true;
                dfs(nums, visited, stack, result);
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        Arrays.sort(nums);
        List<List<Integer>> permute = permuteUnique(nums);
        for (List<Integer> s : permute) {
            System.out.println(s);
        }
    }
}

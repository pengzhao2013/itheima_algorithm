package com.itheima.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zpstart
 * @Date: 2025-07-26 10:30
 * @Description:
 */
public class GetAllPalindromeLeetCode131 {
    public static void main(String[] args) {
        GetAllPalindromeLeetCode131 test = new GetAllPalindromeLeetCode131();
        System.out.println(test.partition("aab"));
    }
    public List<List<String>> partition(String s) {
        LinkedList<String> queue = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, queue, result);
        return result;
    }

    private void partition(String s, int idx, LinkedList<String> queue,
                           List<List<String>> result) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(queue));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (isPalindrome(sub)) {
                queue.offerLast(sub);
                partition(s, i + 1, queue, result);
                queue.pollLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}

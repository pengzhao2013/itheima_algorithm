package com.itheima.exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zpstart
 * @Date: 2025-07-09 19:33
 * @Description:
 */
public class Consecutive_SumN {
    public static void main(String[] args) {
        System.out.println(consecutiveSumN(15));
    }
    private static List<List<Integer>> consecutiveSumN(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> consecutiveLists = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            List<Integer> childConsecutiveList = getChildConsecutiveList(i, n, n);
            if (childConsecutiveList.size() > 0) {
                consecutiveLists.add(childConsecutiveList);
            }
        }
        return consecutiveLists;
    }

    private static List<Integer> getChildConsecutiveList(int startIndex, int endIndex, int expectedSum) {
        List<Integer> childConsecutiveList = new ArrayList<>();
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += i;
            childConsecutiveList.add(i);
            if (sum == expectedSum) {
                return childConsecutiveList;
            }
            if (sum > expectedSum) {
                break;
            }
        }
        return Collections.emptyList();
    }
}

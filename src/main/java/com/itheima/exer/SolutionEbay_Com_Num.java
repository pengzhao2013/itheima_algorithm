package com.itheima.exer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zpstart
 * @Date: 2025-07-09 11:22
 * @Description:
 */
public class SolutionEbay_Com_Num {
    public static int getAllNums(int n) {
        List<Integer> allNumsList = new ArrayList<>();
        if (n == 0 || n == 1) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            if (isAllNum(i)) {
                allNumsList.add(i);
            }
        }
        System.out.println(allNumsList);
        return allNumsList.size();
    }

    private static boolean isAllNum(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if ((n % i) == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println(getAllNums(6));
    }
}
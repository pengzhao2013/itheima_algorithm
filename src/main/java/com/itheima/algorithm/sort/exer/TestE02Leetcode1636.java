package com.itheima.algorithm.sort.exer;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-05-14 19:42
 */
public class TestE02Leetcode1636 {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for (int i : nums) {
            count[i + 100]++;
        }
//        System.out.println(Arrays.toString(count));
        // 按频率升序,频率相同的再按数值降序
        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            int af = count[a + 100];
            int bf = count[b + 100];
            if (af < bf) {
                return -1;
            } else if (af > bf) {
                return 1;
            } else {
                return b - a; // 频率相等则按数值降序
            }
        }).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(new TestE02Leetcode1636().frequencySort(nums)));
    }
}

package com.itheima.leetcode;

/**
 * 盛最多水的容器
 * @author zpstart
 * @create 2025-05-19 13:56
 */
public class MostWaterLeetcode11 {
    static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                int area = (j - i) * height[i];
                max = Math.max(area, max);
                i++;
            } else {
                int area = (j - i) * height[j];
                max = Math.max(area, max);
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
//        System.out.println(maxArea(new int[]{2,1})); // 1
    }
}

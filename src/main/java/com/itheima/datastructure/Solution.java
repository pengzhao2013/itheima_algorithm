package com.itheima.datastructure;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2023-08-28 19:52
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {-1, -4, -5, 9, 8, 3, -6};
        int[] maxChildArray = getMaxChildArray(array);
        System.out.println(Arrays.toString(maxChildArray));
//        int length = maxChildArray[1] - maxChildArray[0] + 1;
//        int[] nums = new int[length];
//        int j = -1;
//        for (int i = maxChildArray[0]; i < maxChildArray[1]; i++) {
//            nums[++j] = array[i];
//        }
//        System.out.println(Arrays.toString(nums));
    }

    private static int[] getMaxChildArray(int[] array) {
        int max = 0;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (max < sum) {
                    begin = i;
                    end = j;
                    max = sum;
                }
            }
        }
        return new int[] {begin, end};
    }
}
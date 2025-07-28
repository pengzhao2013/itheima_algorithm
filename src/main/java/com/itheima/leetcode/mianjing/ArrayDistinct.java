package com.itheima.leetcode.mianjing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 拼多多
 *
 * @Author: zpstart
 * @Date: 2025-07-22 19:11
 * @Description:
 */
public class ArrayDistinct {
    public static void arrayDistinct(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int duplicateNum = 0;
        int k = 0;
        int[] newArray = new int[array.length];
        int[] duplicateArray = new int[array.length];
        for (int num : array) {
            if (map.containsKey(num)) {
                duplicateArray[duplicateNum++] = num;
                continue;
            }
            map.put(num, 1);
            newArray[k++] = num;
        }
        for (int i = 0; i < duplicateNum; i++) {
            newArray[k++] = duplicateArray[i];
        }
        System.arraycopy(newArray, 0, array, 0, array.length);
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 4, 3, 3, 2, 2, 3, 6, 3, 8, 9};
        arrayDistinct(array);
        System.out.println(Arrays.toString(array));
    }
}

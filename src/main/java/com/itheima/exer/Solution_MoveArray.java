package com.itheima.exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zpstart
 * @Date: 2025-07-09 19:58
 * @Description:
 */
public class Solution_MoveArray {
    public static void moveArrayInsertion(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int low = 1; low < array.length; low++) {
            int temp = array[low];
            int i = low - 1;
            while (i >= 0 && isEven(temp) && !isEven(array[i])) {
                array[i + 1] = array[i];
                i--;
            }
            if (i + 1 != low) {
                array[i + 1] = temp;
            }
        }
    }

    private static boolean isEven(int num) {
        return (num & (2 - 1)) == 0;
    }

    public static Integer[] moveArray(int[] array) {
        if (array == null || array.length == 0) {
            return new Integer[]{};
        }
        List<Integer> mappinggedList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }
        mappinggedList.addAll(evenList);
        mappinggedList.addAll(oddList);
        return mappinggedList.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveArray(new int[]{3, 6, 1, 2, 4})));
        int[] arr = new int[]{3, 1, 2, 4};
        moveArrayInsertion(arr);
        System.out.println(Arrays.toString(arr));
    }
}

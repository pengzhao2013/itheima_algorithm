package com.itheima.algorithm.recursion.exer;

/**
 * @author zpstart
 * @create 2025-04-27 22:36
 */
public class E03BinarySearch2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(arr, -6));
    }
    public static int search(int[] a, int target) {
        return search0(a, 0, a.length - 1, target);
    }

    private static int search0(int[] a, int i, int j, int target) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if (target < a[m]) {
            return search0(a, i, m -1, target);
        } else if (target > a[m]) {
            return search0(a, m + 1, j , target);
        } else {
            return m;
        }
    }
}

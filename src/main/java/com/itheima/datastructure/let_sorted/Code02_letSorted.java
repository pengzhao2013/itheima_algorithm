package com.itheima.datastructure.let_sorted;

/**
 * @author zpstart
 * @create 2025-05-07 20:48
 */
public class Code02_letSorted {
    public static boolean canSorted(int[] A, int[] B) {
        return process(A,B, 0, Integer.MIN_VALUE);
    }

    /*
     * 假设index之前A数组都是有序的
     * @author zpstart
     * @return boolean 本次交换或不交换后能否使数组有序
     */
    public static boolean process(int[] A, int[] B, int index, int pre) {
        if (index > A.length - 1) {
            return true;
        }
        // 1.选择不交换
        boolean isSorted1 = pre > A[index] ? false : process(A, B,index + 1, A[index]);

        // 2.选择交换
        boolean isSorted2 = pre > B[index] ? false : process(A, B,index + 1, B[index]);

        return isSorted1 | isSorted2;
    }
}

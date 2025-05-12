package com.itheima.datastructure.sorted_array;

/**
 * @author zpstart
 * @create 2025-05-02 13:48
 */
public class E01MergeTwoSortedArray88 {
    /**
     * 法一：递归
     * @author zpstart
     * @return void
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            System.arraycopy(nums1, 0, nums2, 0, n);
            return;
        }
        if (nums2.length == 0) {
            return;
        }
        int[] newNums1 = new int[m];
        System.arraycopy(nums1, 0, newNums1, 0, m);
        mergeRecursive(newNums1, nums2, nums1, 0, 0, 0);
    }

    private void mergeRecursive(int[] newNum1, int[] nums2, int[] nums1, int i, int j,
                       int k) {
        if (i > newNum1.length - 1) {
            System.arraycopy(nums2, j, nums1, k, nums2.length - j);
            return;
        }
        if (j > nums2.length - 1) {
            System.arraycopy(newNum1, i, nums1, k, newNum1.length - i);
            return;
        }
        if (newNum1[i] < nums2[j]) {
            nums1[k] = newNum1[i];
            mergeRecursive(newNum1, nums2, nums1, i + 1, j, k + 1);
        } else {
            nums1[k] = nums2[j];
            mergeRecursive(newNum1, nums2, nums1, i, j + 1, k + 1);
        }
    }

    private void mergeNotRecursive(int[] newNum1, int[] nums2, int[] nums1) {
        int i = 0, j = 0, k = 0;
        while (i < newNum1.length && j < nums2.length) {
            if (newNum1[i] < nums2[j]) {
                nums1[k++] = newNum1[i];
                i++;
            } else {
                nums1[k++] = nums2[j];
                j++;
            }
        }
        if (i == newNum1.length) {
            System.arraycopy(nums2, j, nums1, k, nums2.length - j);
        }
        if (j == nums2.length) {
            System.arraycopy(newNum1, i, nums1, k, newNum1.length - i);
        }
    }
}

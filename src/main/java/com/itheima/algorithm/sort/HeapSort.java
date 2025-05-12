package com.itheima.algorithm.sort;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-04-15 10:48
 */
public class HeapSort {
    public static void sort(int[] a) {
        heapify(a, a.length); // 先heapify成大顶堆
//        downRecursion(a, 0, a.length);
        for (int right = a.length - 1; right > 0; right--) { // 再交换第0个与最后一个元素 再
            swap(a, 0, right);
            downRecursion(a, 0, right); // 重新调整成大顶堆 right相当于maxHeap.size--;
//            heapify(a, right); // 不包含right
        }
    }

    private static void heapify(int[] array, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            downRecursion(array, i, size); // 从非叶子节点开始倒着来
        }
    }

    private static void downRecursion(int[] array, int parent, int size) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) { // 找到了更大的孩子
            swap(array, max, parent);
            downRecursion(array, max, size);
        }
    }

    private static void downNotRecursion(int[] array, int parent, int size) {
        while (true) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int max = parent;
            if (left < size && array[left] > array[max]) {
                max = left;
            }
            if (right < size && array[right] > array[max]) {
                max = right;
            }
            if (max == parent) {
                // 没找到更大孩子
                break;
            }
            swap(array, max, parent);
            parent = max;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {5, 30, 7, 26, 25};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}

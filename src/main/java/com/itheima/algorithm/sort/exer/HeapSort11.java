package com.itheima.algorithm.sort.exer;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-05-20 11:45
 */
public class HeapSort11 {
    public void sort(int[] arr) {
        heapify(arr, arr.length);
        for (int right = arr.length - 1; right > 0; right--) {
            swap(arr, 0, right);
            down(arr, 0, right);
        }
    }

    private void heapify(int[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(arr, i, size);
        }
    }

    private void down(int[] array, int parent, int size) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[parent]) {
            max = left;
        }
        if (right < size && array[right] > array[parent]) {
            max = right;
        }
        if (max != parent) {
            swap(array, max, parent);
            down(array, max, size);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {5, 30, 7, 26, 25};
        System.out.println(Arrays.toString(a));
        HeapSort11 heapSort11 = new HeapSort11();
        heapSort11.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

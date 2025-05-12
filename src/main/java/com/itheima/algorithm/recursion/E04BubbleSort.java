package com.itheima.algorithm.recursion;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2023-08-02 22:54
 */
public class E04BubbleSort {
    public static void sort(int[] a) {
        bubble1(a, a.length - 1);
    }

    private static void bubble1(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                x = i;
            }
        }
        bubble1(a, x);
    }

    private static void bubble2(int[] arr, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                x = i;
            }
        }
        bubble2(arr, x);
    }

    private static void bubble(int[] arr) {
        int j = arr.length - 1;
        int x = 0;
        while (true) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    x = i;
                }
            }
            j = x;
            if (j == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

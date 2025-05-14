package com.itheima.algorithm.sort;

import com.itheima.datastructure.DynamicArray;

import java.util.Arrays;

/**
 * @Author : zpstart
 * @Date: 2025-05-14 16:35
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] ages = {9, 0, 5, 1, 3, 2, 4, 6, 8, 7};
        sort(ages, 3);
        System.out.println(Arrays.toString(ages));
    }

    public static void sort(int[] ages, int range) {
        int max = ages[0];
        int min = ages[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] > max) {
                max = ages[i];
            }
            if (ages[i] < min) {
                min = ages[i];
            }
        }
        // 1.准备桶
        DynamicArray[] buckets = new DynamicArray[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new DynamicArray();
        }
        for (int age : ages) {
            buckets[(age - min) / range].addLast(age);
        }
        int k = 0;
        for (DynamicArray bucket : buckets) {
            // 3.排序桶内元素
            int[] array = bucket.array();
            if (array.length > 0) {
                InsertionSort.sort(array);
            }
            System.out.println(Arrays.toString(bucket.array()));
            // 4.把每个桶排序后的内容依次放入原始数组
            for (int v : array) {
                ages[k++] = v;
            }
        }
    }
}

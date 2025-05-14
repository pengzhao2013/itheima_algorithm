package com.itheima.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 基数排序 最低有效数字 LSD  least significant digit
 * @Author : zpstart
 * @Date: 2025-05-14 17:13
 */
public class RadixSort {
    public static void radix(String[] a, int length) {
        // 1.准备桶
        ArrayList<String>[] buckets = new ArrayList[128];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = length - 1; i >= 0; i--) {
            for (String s : a) {
//                buckets[s.charAt(i) - '0'].add(s);
                buckets[s.charAt(i)].add(s);
            }
            int k = 0;
            for (ArrayList<String> bucket : buckets) {
//            System.out.println(bucket);
                // 放回原始数组
                for (String s : bucket) {
                    a[k++] = s;
                }
                bucket.clear();
            }
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        String[] phoneNumbers = new String[6];
        phoneNumbers[0] = "13a1";
        phoneNumbers[1] = "25b8";
        phoneNumbers[2] = "13c9";
        phoneNumbers[3] = "16d1";
        phoneNumbers[4] = "16e8";
        phoneNumbers[5] = "13f2";
        radix(phoneNumbers, 3);
    }
}

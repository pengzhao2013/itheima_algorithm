package com.itheima.algorithm.binarysearch;


import java.util.Arrays;

/**
 * @author zpstart
 * @create 2023-07-08 8:59
 */
public class BinarySearch {
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;    // 设置指针和初值
        // L 次  元素在最左边 L 次，  元素在最右边 2*L 次
        while (i <= j) {                // i~j 范围内有东西
            int m = (i + j) >>> 1;
            if (target < a[m]) {         // 目标在左边
                j = m - 1;
            } else if (a[m] < target) { // 目标在右边
                i = m + 1;
            } else {                    // 找到了
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchAlternative(int[] a, int target) {
        /**
         * 同一个二进制数 不把/把最高位当成符号位
         */
        int i = 0, j = a.length;     // 第一处
        while (i < j) {              // 第二处  j只是作为边界，指向的一定不是查找目标 不会参与运算
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;               // 第三处 cg(n) >= f(n) 则O(g(n))为时间复杂度 cg(n)为渐进上界 表示最差情况
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) { // 之间的元素个数 > 1   i指向的可能是目标 j不是目标 在循环外找到元素 或i + 1 < j
            int m = (i + j) >>> 1;
            if (target < a[m]) { // 比较次数平衡了
                j = m;
            } else {
                i = m;
            }
        }
        if (a[i] == target) {
            return i;
        } else {
            return -1;
        }
    }

    public static int binarySearchLeftMost(int[] a, int target) {
        int i = 0, j = a.length - 1;    // 设置指针和初值
        // L 次  元素在最左边 L 次，  元素在最右边 2*L 次
        int candidate = -1;
        while (i <= j) {                // i~j 范围内有东西
            int m = (i + j) >>> 1;
            if (target < a[m]) {         // 目标在左边
                j = m - 1;
            } else if (a[m] < target) { // 目标在右边
                i = m + 1;
            } else {                    // 找到了
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    // 返回 >= target的最左索引
    public static int binarySearchLeftMost2(int[] a, int target) {
        int i = 0, j = a.length - 1;    // 设置指针和初值
        // L 次  元素在最左边 L 次，  元素在最右边 2*L 次
//        int candidate = -1;
        while (i <= j) {                // i~j 范围内有东西
            int m = (i + j) >>> 1;
            if (target <= a[m]) {         // 目标在左边
                j = m - 1;
            } else { // 目标在右边 (a[m] < target)
                i = m + 1;
            }
//            else {                    // 找到了
////                candidate = m;
//                j = m - 1;
//            }
        }
        return i; // a[m] < target i = m + 1 a[m] > target
    }

    public static int binarySearchRightMost(int[] a, int target) {
        int i = 0, j = a.length - 1;    // 设置指针和初值
        // L 次  元素在最左边 L 次，  元素在最右边 2*L 次
        int candidate = -1;
        while (i <= j) {                // i~j 范围内有东西
            int m = (i + j) >>> 1;
            if (target < a[m]) {         // 目标在左边
                j = m - 1;
            } else if (a[m] < target) { // 目标在右边
                i = m + 1;
            } else {                    // 找到了
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    // 返回小于等于target的最靠右索引
    public static int binarySearchRightMost2(int[] a, int target) {
        int i = 0, j = a.length - 1;    // 设置指针和初值
        // L 次  元素在最左边 L 次，  元素在最右边 2*L 次
//        int candidate = -1;
        while (i <= j) {                // i~j 范围内有东西
            int m = (i + j) >>> 1;
            if (target < a[m]) {         // 目标在左边
                j = m - 1;
            } else { // 目标在右边 else if a[m] < target
                i = m + 1;
            }
//            else {                    // 找到了
//                candidate = m;
//                i = m + 1;
//            }
        }
        return i - 1;
    }

    public static void main0(String[] args) {
        int i = 0;
        int j = Integer.MAX_VALUE - 1;
        int m = (i + j) / 2;
        i = m + 1;
        System.out.println(i);
        System.out.println(j);
        System.out.println((i + j) / 2);
        System.out.println((i + j) >>> 2);

//        Arrays.binarySearch() 返回:  插入点-1 return -(low + 1); low/i:插入点位置

        int[] a = {2, 5, 8};
        int target = 4;
        int index = Arrays.binarySearch(a, target);
        System.out.println(index);
        if (index < 0) {
            int insertion = Math.abs(index + 1);
            int[] b = new int[a.length + 1];
            System.arraycopy(a, 0, b, 0, insertion);
            b[insertion] = target;
            System.arraycopy(a, insertion, b, insertion + 1, a.length - insertion);
            System.out.println(Arrays.toString(b));
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 4, 4, 5, 7, 8, 9};
        System.out.println(binarySearchLeftMost2(a, 4));
        System.out.println(binarySearchRightMost2(a, 6));
    }


}

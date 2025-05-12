package com.itheima.algorithm.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.itheima.algorithm.binarysearch.BinarySearch.binarySearchAlternative;
import static com.itheima.algorithm.binarysearch.BinarySearch.binarySearchBasic;

/**
 * @author zpstart
 * @create 2023-07-08 9:05
 */
public class TestBinarySearch {
    @Test
    @DisplayName("测试 binarySearchBasic")
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        Assertions.assertEquals(0, binarySearchBasic(a, 7));
        Assertions.assertEquals(1, binarySearchBasic(a, 13));
        Assertions.assertEquals(2, binarySearchBasic(a, 21));
        Assertions.assertEquals(3, binarySearchBasic(a, 30));
        Assertions.assertEquals(4, binarySearchBasic(a, 38));
        Assertions.assertEquals(5, binarySearchBasic(a, 44));
        Assertions.assertEquals(6, binarySearchBasic(a, 52));
        Assertions.assertEquals(7, binarySearchBasic(a, 53));

        Assertions.assertEquals(-1, binarySearchBasic(a, 0));
        Assertions.assertEquals(-1, binarySearchBasic(a, 15));
        Assertions.assertEquals(-1, binarySearchBasic(a, 60));
    }

    @Test
    @DisplayName("测试 binarySearchAlternative ")
    public void test3() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        Assertions.assertEquals(0, binarySearchAlternative(a, 7));
        Assertions.assertEquals(1, binarySearchAlternative(a, 13));
        Assertions.assertEquals(2, binarySearchAlternative(a, 21));
        Assertions.assertEquals(3, binarySearchAlternative(a, 30));
        Assertions.assertEquals(4, binarySearchAlternative(a, 38));
        Assertions.assertEquals(5, binarySearchAlternative(a, 44));
        Assertions.assertEquals(6, binarySearchAlternative(a, 52));
        Assertions.assertEquals(7, binarySearchAlternative(a, 53));

        Assertions.assertEquals(-1, binarySearchAlternative(a, 0));
        Assertions.assertEquals(-1, binarySearchAlternative(a, 15));
        Assertions.assertEquals(-1, binarySearchAlternative(a, 60));
    }

    @Test
    @DisplayName("测试 binarySearch java 版")
    public void test5() {
    /*
            ⬇
        [2, 5, 8]       a
        [2, 0, 0, 0]    b
        [2, 4, 0, 0]    b
        [2, 4, 5, 8]    b
     */
        int[] a = {2, 5, 8};
        int target = 4;
        int i = Arrays.binarySearch(a, target);
        Assertions.assertTrue(i < 0);
        // i = -插入点 - 1  因此有 插入点 = abs(i+1)
        int insertIndex = Math.abs(i + 1); // 插入点索引
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, insertIndex);
        b[insertIndex] = target;
        System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
        Assertions.assertArrayEquals(new int[]{2, 4, 5, 8}, b);
    }
}

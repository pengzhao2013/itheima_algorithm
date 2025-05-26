package com.itheima.leetcode;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

/**
 * @Author : zpstart
 * @Date: 2025-05-26 9:13
 */
public class MinWindowLeetcode76_2 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("aaabbbbbcdd", "abcdd")); // abbbbbcdd
    }

    static class Result {
        int i;
        int j;

        public Result(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    /*
        1. 统计目标串需要各种字符个数， 统计原始串 i~j 范围各种字符个数
        2. 如果原始串 i~j 范围内不满足条件，j++ 扩大范围，直到满足条件 j 停下来
        3. 一旦满足条件 i++ 缩小范围，直到再次不满足条件 ...
        4. 重复 2. 3. 两步直至 j 到达原始串末尾
     */
    static String minWindow(String s, String t) {
        char[] target = t.toCharArray();
        int[] targetCount = new int[128]; // 目标串字符各出现几次
        for (char ch : target) {
            targetCount[ch]++;
        }
        int passTotal = 0; // 条件总数
        for (int count : targetCount) {
            if (count > 0) {
                passTotal++;
            }
        }

        int passed = 0; // 已通过的条件数
        char[] source = s.toCharArray();
        int[] sourceCount = new int[128]; // 原始串i~j范围内字符各出现几次
        int i = 0;
        int j = 0;
        Result result = null;
        while (j < source.length) {
            // 扩大 j 范围，更新范围内字符计数 和 通过条件数
            char right = source[j];
            sourceCount[right]++;
            if (sourceCount[right] == targetCount[right]) {
                passed++;
            }
//            System.out.println("处理的字符:" + right + " 通过数:" + passed);
//            print(sourceCount);
//            System.out.println("----------------------------------------");
            // 若已满足所有条件，缩小 i 范围，更新范围内字符计数 和 通过条件数
            while (passed == passTotal && i <= j) { // 仍然满足条件 不断缩小i
                if (result == null) {
                    result = new Result(i, j);
                } else {
                    if (j - i < result.j - result.i) {
                        result = new Result(i, j);
                    }
                }
                char left = source[i];
                sourceCount[left]--;
                if (sourceCount[left] < targetCount[left]) {
                    passed--;
                }
                i++;
            }
            j++;
        }
        System.out.println(result.i + " " + result.j);
        return result == null ? "" : new String(source, result.i, result.j - result.i + 1);
    }

    static void print(int[] count) {
        System.out.println(IntStream.range(0, count.length)
                .filter(i -> count[i] != 0)
                .boxed()
                .collect(toMap(i -> (char) i.intValue(), i -> count[i])));
    }
}

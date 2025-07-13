package com.itheima.apis;

import com.itheima.datastructure.linkedlist.ListNode;
import org.springframework.util.StopWatch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zpstart
 * @Date: 2025-07-10 22:15
 * @Description:
 */
public class FrequentlyUsedApis {
    public static void main(String[] args) {
//        IntStream.of(Arrays.copyOfRange(array, 0, size)); // copyOfRange:含头不含尾

        int rows = 1000000;
        int columns = 14;
        int[][] a = new int[rows][columns];

        StopWatch sw = new StopWatch();
        sw.start("ij");
//        ij(a, rows, columns);
        sw.stop();
        sw.start("ji");
//        ji(a, rows, columns);
        sw.stop();
        System.out.println(sw.prettyPrint());


//        (capacity & capacity - 1) == 0 // 减法运算优先级高 capacity为2的幂
//        取模转化为:
//        array[tail & array.length - 1] = value; // tail本身不是索引，需要根据tail计算出索引 减法运算优先级高
    }

    public static void main0(String[] args) {
        // 取大于c的最接近的2的n次幂
        int c = 30;
//        int n = (int) (Math.log10(c - 1) / Math.log10(2)) + 1;
//        System.out.println(n);
//        System.out.println(1 << n);

        c -= 1;
        c |= c >> 1;
        c |= c >> 2;
        c |= c >> 4;
        c |= c >> 8;
        c |= c >> 16;
        c += 1;
        System.out.println(c);

        // 代替取模运算
//        array[tail & (array.length - 1)] = value;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    }
}

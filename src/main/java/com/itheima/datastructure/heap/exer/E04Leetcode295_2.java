package com.itheima.datastructure.heap.exer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * jdk自带堆：PriorityQueue  B-大顶堆 A-小顶堆  偶数->加入B前先加入A 防止有特别大的数加入B
 * 奇数->加入A前先加入B 防止有特别小的数加入A  每次都是把B中大的挪向A A中小的数挪向B
 * B中存的是小的一半数字 A中存的是大的一半数字
 * @author zpstart
 * @create 2025-05-03 21:52
 */
public class E04Leetcode295_2 {
    private PriorityQueue<Integer> left = new PriorityQueue<>((a, b) ->
            Integer.compare(b, a));

    /**
     * 默认是小顶堆
     * @author zpstart
     * @return
     */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    // (a, b) -> Integer.compare(a, b);

    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    public static void main(String[] args) {
        /*E04Leetcode295_2 test = new E04Leetcode295_2();
        test.addNum(1);
        test.addNum(2);
        test.addNum(3);
        test.addNum(7);
        test.addNum(8);
        test.addNum(9);
        System.out.println(test.findMedian());
        test.addNum(10);
        System.out.println(test.findMedian());
        test.addNum(4);
        System.out.println(test.findMedian());*/

        // 以上浮为例, 大概的实现逻辑
//        Comparator<Integer> cmp = (a, b) -> Integer.compare(a, b); // 小顶堆比较器 compare -1 a<b, 0 a==b, 1 a>b
        Comparator<Integer> cmp = (a, b) -> Integer.compare(b, a); // 大顶堆比较器 compare -1 b<a, 0 b==a, 1 b>a
        int a = 10; // 父元素值
        int b = 20; // 新增元素值
        if (cmp.compare(a, b) > 0) { // compare(父,子)
            System.out.println("上浮");
        } else {
            System.out.println("停止上浮");
        }
    }
}

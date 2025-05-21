package com.itheima.datastructure.heap.exer;

import java.util.PriorityQueue;

/**
 * @author zpstart
 * @create 2025-05-20 15:37
 */
public class E04Leetcode295_3 {
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);

    PriorityQueue<Integer> right = new PriorityQueue<>();

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
}

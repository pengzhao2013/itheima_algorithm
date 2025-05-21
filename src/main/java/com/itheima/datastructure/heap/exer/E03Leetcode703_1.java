package com.itheima.datastructure.heap.exer;

import java.util.PriorityQueue;

/**
 * @author zpstart
 * @create 2025-05-20 15:20
 */
public class E03Leetcode703_1 {
    private PriorityQueue<Integer> minHeap;

    int k;

    public E03Leetcode703_1(int k, int[] nums) {
        minHeap = new PriorityQueue<>();

        this.k = k;
    }

    public int add(int val) {
        if (minHeap.size() <= k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

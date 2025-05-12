package com.itheima.datastructure.heap.exer;

/**
 * @author zpstart
 * @create 2025-05-03 19:28
 */
public class E03Leetcode703 {
    private MinHeap minHeap;

    public E03Leetcode703(int k, int[] nums) {
        this.minHeap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (!minHeap.isFull()) {
            minHeap.offer(val);
        }else if (val > minHeap.peek()) {
            minHeap.replace(val);
        }
        return minHeap.peek();
    }
}

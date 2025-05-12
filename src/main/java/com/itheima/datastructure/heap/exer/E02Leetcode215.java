package com.itheima.datastructure.heap.exer;

/**
 * @author zpstart
 * @create 2025-05-03 18:29
 */

/**
 * <h3>求数组中第 K 大的元素</h3>
 * <p>
 * 解体思路
 * <ol>
 *     <li>向小顶堆放入前k个元素</li>
 *     <li>剩余元素</li>
 *     <ul>
 *         <li>若 <= 堆顶元素, 则略过</li>
 *         <li>若 > 堆顶元素, 则替换堆顶元素</li>
 *     </ul>
 *     <li>这样小顶堆始终保留的是到目前为止, <b>前 K 大</b>的元素</li>
 *     <li>循环结束, 堆顶元素即为<b>第 K 大</b>元素</li>
 * </ol>
 */
public class E02Leetcode215 {

    public static int findKthLargest(int[] nums, int k) {
        MinHeap minHeap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.replace(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 4, 1, 3, 6, 0};
        System.out.println(findKthLargest(array, 4));
    }
}

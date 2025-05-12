package com.itheima.datastructure.heap;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2023-09-16 8:02
 */
public class MaxHeap {
    int[] array;

    int size;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 可能会传来普通数组
     * @author zpstart
     * @return
     */
    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    private void heapify() {
        // 最后一个非叶子节点 size / 2 - 1 开始从后往前下潜
        // 适用起始索引为0的堆
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    public int poll() {
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    public int poll(int index) {
        // 未考虑堆为空
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    public int peek() {
        return array[0];
    }

    public boolean offer(int offered) { // 一个个offer O(nlog(n))
        if (size == array.length) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    /**
     * 上浮
     * @author zpstart
     * @return void
     */
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered > array[parent]) {
                array[child] = array[parent];
                child = parent;
            } else {
                break;
            }
        }
        array[child] = offered;
    }

    // 将parent 索引处的元素下潜：与两个孩子较大者交换，直至没孩子或孩子没它大
    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) { // 找到了更大的孩子
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));
        // 堆排序：
        while (maxHeap.size > 0) {
            maxHeap.swap(0, maxHeap.size - 1);
            maxHeap.size--;
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(maxHeap.array));
    }
}

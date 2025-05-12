package com.itheima.datastructure.heap.exer;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-05-03 18:23
 */
public class MinHeap {
    int[] array;

    int size;

    public MinHeap(int capacity) {
        this.array = new int[capacity];
    }

    public boolean isFull() {
        return size == array.length;
    }

    /**
     * 可能会传来普通数组
     * @author zpstart
     * @return
     */
    public MinHeap(int[] array) {
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

    public boolean offer(int offered) {
        if (size == array.length) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    /**
     * 将 offered 元素上浮: 直至 offered 小于父元素或到堆顶
     * @author zpstart
     * @return void
     */
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered < array[parent]) {
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
        int min = parent;
        if (left < size && array[left] < array[min]) {
            min = left;
        }
        if (right < size && array[right] < array[min]) {
            min = right;
        }
        if (min != parent) { // 找到了更大的孩子
            swap(min, parent);
            down(min);
        }
    }

    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {8, 2, 3, 4, 5, 6, 7};
        MinHeap minHeap = new MinHeap(array);
        System.out.println(Arrays.toString(minHeap.array));
    }
}

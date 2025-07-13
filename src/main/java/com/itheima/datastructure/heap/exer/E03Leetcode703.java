package com.itheima.datastructure.heap.exer;

/**
 * @author zpstart
 * @create 2025-05-03 19:28
 */
public class E03Leetcode703 {
    private MinHeap1 minHeap;

    public E03Leetcode703(int k, int[] nums) {
        this.minHeap = new MinHeap1(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (!minHeap.isFull()) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.replace(val);
        }
        return minHeap.peek();
    }

    static class MinHeap1 {
        int[] array;

        int size;
        public MinHeap1(int capacity) {
            this.array = new int[capacity];
        }

        public MinHeap1(int[] array) {
            this.array = array;
            this.size = array.length;
            heapify();
        }

        public boolean isFull() {
            return size == array.length;
        }

        public void heapify() {
            for (int i = size / 2 - 1; i >= 0; i--) {
                down(i);
            }
        }

        public int peek() {
            return array[0];
        }

        public boolean offer(int offered) {
            if (isFull()) {
                return false;
            }
            up(offered);
            size++;
            return true;
        }

        private void up(int offered) {
            int child = size;
            int parent = (child - 1) / 2;
            while (child > 0 && offered < array[parent]) {
                array[child] = array[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            array[child] = offered;
        }

        public void down(int parent) {
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

        public void replace(int replaced) {
            array[0] = replaced;
            down(0);
        }

        public int poll() {
            int top = array[0];
            swap(0, size - 1);
            size--;
            down(0);
            return top;
        }

        private void swap(int i, int j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }
}

package com.itheima.leetcode;


/**
 * @author zpstart
 * @create 2025-05-21 15:51
 */
public class ListQueue  {
    private int[] arr;

    private int size;

    private int head;

    private int tail;

    public void offer(int element) {
        if (!isFull()) {
            arr[tail] = element;
            tail = (tail + 1) % arr.length;
            size++;
        }
    }
    public int poll() {
        int element =  arr[head];
        head = (head + 1) % arr.length;
        size--;
        return element;
    }


    private boolean isFull() {
        return arr.length == size;
    }
}

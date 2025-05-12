package com.itheima.datastructure.Deque;

import com.itheima.datastructure.deque.ArrayDeque1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author zpstart
 * @create 2023-09-13 21:14
 */
public class TestArrayDeque1 {
    @Test
    public void offer() {
        ArrayDeque1<Integer> deque = new ArrayDeque1<Integer>(3);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        Assertions.assertFalse(deque.offerLast(4));
    }

    @Test
    public void poll() {
        ArrayDeque1<Integer> deque = new ArrayDeque1<Integer>(7);
        Assertions.assertTrue(deque.isEmpty());
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerFirst(4);
        deque.offerFirst(5);
        deque.offerFirst(6);
        deque.offerFirst(7);
        Assertions.assertTrue(deque.isFull());
    }
}

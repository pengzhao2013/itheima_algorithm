package com.itheima.datastructure.Deque;

import com.itheima.datastructure.deque.LinkedListDeque;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 * @author zpstart
 * @create 2023-09-12 20:04
 */
public class TestLinkedDeque {
    @Test
    public void offer() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        assertFalse(deque.offerLast(6));
    }

    @Test
    public void poll() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);
    }
}

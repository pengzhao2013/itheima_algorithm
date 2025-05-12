package com.itheima.datastructure.deque;

/**
 * double ended queue
 * @author zpstart
 * @create 2023-09-12 18:37
 */
public interface Deque<E> {
    boolean offerFirst(E e);

    boolean offerLast(E e);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}

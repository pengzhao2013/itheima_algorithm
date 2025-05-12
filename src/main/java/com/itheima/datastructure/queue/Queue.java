package com.itheima.datastructure.queue;

/**
 * 尾进头出
 * @author zpstart
 * @create 2023-08-28 22:18
 */
public interface Queue<E> {
    boolean offer(E value);

    E poll();

    E peek();

    boolean isEmpty();

    boolean isFull();
}

package com.itheima.datastructure.stack;

/**
 * 顶部添加移除
 *
 * @author zpstart
 * @create 2023-08-31 21:39
 */
public interface Stack<E> {
    boolean push(E value);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();
}

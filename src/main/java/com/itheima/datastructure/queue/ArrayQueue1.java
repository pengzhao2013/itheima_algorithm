package com.itheima.datastructure.queue;

import java.util.Iterator;
import java.util.Objects;

/**
 * 添加一端：尾 移除一端：头 tail指向的位置不存储元素
 *
 * @author zpstart
 * @create 2023-08-29 21:43
 */
public class ArrayQueue1<E> implements Queue<E>, Iterable<E> {
    private E[] array;

    private int head = 0; // 只用head和tail两个指针时必须要浪费一个空间

    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }
}

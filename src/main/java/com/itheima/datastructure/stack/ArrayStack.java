package com.itheima.datastructure.stack;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author zpstart
 * @create 2023-08-31 22:20
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private E[] array;

    /*
     * 底    顶
     * 0 1 2 3
     * a
     *   top == arr.length时满
     */
    private int top; // 栈顶指针

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return array[--top];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator iterator() { // 从栈顶开始遍历
        return new Iterator() {
            int p = top;
            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public Object next() {
                return array[--p];
            }
        };
    }
}

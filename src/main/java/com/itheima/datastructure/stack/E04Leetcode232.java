package com.itheima.datastructure.stack;

import java.util.Iterator;

/**
 * @author zpstart
 * @create 2023-09-01 16:48
 */
public class E04Leetcode232 {
    static class ArrayStack<E> implements Stack<E>, Iterable<E> {
        private E[] array;

        private int top; // 栈顶指针

        public ArrayStack(int capacity) {
            array = (E[]) new Object[capacity];
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
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                int p = top;

                @Override
                public boolean hasNext() {
                    return top > 0;
                }

                @Override
                public E next() {
                    return array[--p];
                }
            };
        }
    }

    ArrayStack<Integer> s1 = new ArrayStack<>(100);

    ArrayStack<Integer> s2 = new ArrayStack<>(100);

    public void push(int x) {
        s2.push(x);
    }

    public int pop() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
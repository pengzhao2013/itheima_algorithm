package com.itheima.datastructure.stack;

import java.util.Iterator;

/**
 * @author zpstart
 * @create 2023-08-31 21:45
 */
public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
    private int capacity;

    private int size;

    private Node<E> head = new Node<>(null, null); // 哨兵节点

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null; // size == 0
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Object next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    static class Node<E> {
        E value;

        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}

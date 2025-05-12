package com.itheima.datastructure.queue;

import java.util.Iterator;

/**
 * 1.用单向环形链表实现队列
 * @author zpstart
 * @create 2023-08-28 22:12
 */
public class LinkedListQueue<E>
        implements Queue<E>, Iterable<E> {

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null, null);

    private Node<E> tail = head;

    private int size;

    private int capacity = Integer.MAX_VALUE;

    {
        tail.next = head; // 构造方法中有重复代码时可以写到代码块里
    }
    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public LinkedListQueue() {
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> added = new Node(value, head); // 修改三个指针 1.原来的尾巴->新的节点 2.tail ->新节点 3.新节点.next -> head
        tail.next = added; // tail即当前最后一个节点 原来的尾巴 next指针指向新增节点
        tail = added; // tail随即指向新增节点即最后一个节点
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        if (first == tail) { // 节点只有一个时
            tail = head;
        }
        size--;
        return first.value;
    }

    /*
     * 返回队列头的值
     * @author zpstart
     * @return E
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
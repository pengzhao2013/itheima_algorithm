package com.itheima.datastructure.circular;

import java.util.Iterator;

/**
 * 双向环形链表带哨兵 这时哨兵既作为头也作为尾
 *
 * @author zpstart
 * @create 2023-07-30 20:58
 */
public class DoublyLinkedListSentinel implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;

        int value;

        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoublyLinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = sentinel;
        Node b = sentinel.next;
        a.next = b;
        b.prev = a;
    }

    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) { // 当removed本身就是哨兵
            throw new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            return;
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d]不合法%n", index));
    }

    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}

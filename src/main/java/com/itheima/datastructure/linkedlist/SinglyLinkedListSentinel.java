package com.itheima.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author zpstart
 * @create 2023-07-30 11:26
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    private Node head = new Node(666, null); // 头指针指向哨兵节点

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator();
    }

    private static class Node {
        int value;

        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        // 链表为空
        // head = new Node(value, null);

        // 链表非空
//        head.next = new Node(value, head.next);
        insert(0, value);
    }

    public void loop1(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head.next;

        @Override
        public boolean hasNext() { // 是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() { // 返回当前值
            int v = p.value;
            p = p.next;
            return v;
        }
    }

    private Node findLast() {
        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();

        last.next = new Node(value, null);
    }

    //    public void test() {
//        int i = 0;
//        for (Node p = head; p != null ; p = p.next, i++) {
//            System.out.println(p.value + " 索引是：" + i);
//        }
//    }
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null ; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            // 抛异常
            throw illegalIndex(index);
        }
        return node.value;
    }
    /**
     * 向索引位置插入
     */
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1); // 上一个节点
        if (prev == null) {
            // 抛异常
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d]不合法%n", index));
    }

    public void removeFirst() {
        remove(0);
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next; // 被删除的节点
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }
}
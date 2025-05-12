package com.itheima.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author zpstart
 * @create 2023-07-28 22:22
 */
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head = null; // head指向第一个节点

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator();
    }

    private static class Node { // 对外隐藏使用细节
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
        head = new Node(value, head); // head指向原来的第一个节点
    }

    /**
     * 遍历链表
     * @author zpstart
     * @return void
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head; // pointer
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    public void loop3(Consumer<Integer> before,
                      Consumer<Integer> after) {
        recursion(head, before, after);
    }

    public void recursion(Node curr, Consumer<Integer> before,
                          Consumer<Integer> after) {
        if (curr == null) {
            return;
        }
        before.accept(curr.value);
        recursion(curr.next, before, after);
        after.accept(curr.value);
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head;

        @Override
        public boolean hasNext() { // 是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() { // 返回当前值,并指向下一个元素
            int v = p.value;
            p = p.next;
            return v;
        }
    }

    private Node findLast() {
        if (head == null) { // 空链表
            return null;
        }
        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

//    public void test() {
//        int i = 0;
//        for (Node p = head; p != null ; p = p.next, i++) {
//            System.out.println(p.value + " 索引是：" + i);
//        }
//    }
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null; // 没有找到
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
        if (head == null) {
            throw illegalIndex(0);
        }
        head = head.next;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
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

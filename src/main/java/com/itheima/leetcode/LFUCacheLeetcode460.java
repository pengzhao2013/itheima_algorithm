package com.itheima.leetcode;

import java.util.HashMap;

/**
 * 最不经常使用
 * @Author : zpstart
 * @Date: 2025-05-26 11:05
 */
public class LFUCacheLeetcode460 {
    static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        int freq = 1; // 频度

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DoublyLinkedList {
        Node head;
        Node tail;

        int size;

        public DoublyLinkedList() {
            head = tail = new Node(); // 作为哨兵
            head.next = tail;
            tail.prev = head;
        }
        // 头部添加 head<->1<->2<->tail
        public void addFirst(Node newFirst) { // O(1)
            Node oldFirst = head.next;
            newFirst.prev = head;
            newFirst.next = oldFirst;
            head.next = newFirst;
            oldFirst.prev = newFirst;
            size++;
        }

        // 已知节点删除
        public void remove(Node node) { // O(1)
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        // 尾部删除
        public Node removeLast() {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    private final HashMap<Integer, Node> kvMap =
            new HashMap<>();

    private final HashMap<Integer, DoublyLinkedList> freqMap =
            new HashMap<>();

    private int capacity;

    private int minFreq = 1;

    public LFUCacheLeetcode460(int capacity) {
        this.capacity = capacity;
    }

    /*
            key 不存在
                返回 -1
            key 存在
                返回 value 值
                增加节点的使用频度，将其转移到频度+1的链表当中
         */
    public int get(int key) {
        if (!kvMap.containsKey(key)) {
            return -1;
        }
        Node node = kvMap.get(key);
        DoublyLinkedList oldList = freqMap.get(node.freq);
        oldList.remove(node);
        if (oldList.isEmpty() && node.freq == minFreq) {
            minFreq++;
        }
        node.freq++;
        /*DoublyLinkedList list = freqMap.get(node.freq);
        if (list == null) {
            list = new DoublyLinkedList();
            freqMap.put(node.freq, list);
        }
        list.addFirst(node);*/
        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList())
                .addFirst(node);
        return node.value;
    }

    /*
            更新
                将节点的 value 更新，增加节点的使用频度，将其转移到频度+1的链表当中
            新增
                检查是否超过容量，若超过，淘汰 minFreq 链表的最后节点
                创建新节点，放入 kvMap，并加入频度为 1 的双向链表
         */
    public void put(int key, int value) {
        if (kvMap.containsKey(key)) {
            Node node = kvMap.get(key);
            DoublyLinkedList oldList = freqMap.get(node.freq);
            oldList.remove(node);
            if (oldList.isEmpty() && node.freq == minFreq) {
                minFreq++;
            }
            node.freq++;
            freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList())
                    .addFirst(node);
            node.value = value;
        } else {
            // 按题目要求先检查容量 先加入的话可以判断大于capacity
            if (kvMap.size() == capacity) {
                Node node = freqMap.get(minFreq).removeLast();
                kvMap.remove(node.key);
            }
            Node node = new Node(key, value);
            kvMap.put(key, node);
            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirst(node);
            minFreq = 1;
        }
    }
}

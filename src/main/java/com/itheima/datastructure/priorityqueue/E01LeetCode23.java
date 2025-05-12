package com.itheima.datastructure.priorityqueue;


import com.itheima.datastructure.linkedlist.ListNode;

/**
 * 合并多个有序链表
 *
 * @author zpstart
 * @create 2025-05-03 13:34
 */
public class E01LeetCode23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        MinHeap minHeap = new MinHeap(lists.length);
        for (ListNode headNode : lists) {
            if (headNode != null) {
                minHeap.offer(headNode);
            }
        }
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            p.next = minNode;
            p = minNode;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(-8,-7,-7,-5,1,1,3,4),
                ListNode.of(-10,-10,-7,0,1,3),
                ListNode.of(-2),
                ListNode.of(2)
        };
        ListNode listNode = mergeKLists(lists);
        System.out.println(listNode);
    }
}

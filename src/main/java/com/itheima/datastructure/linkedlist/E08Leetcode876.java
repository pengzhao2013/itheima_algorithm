package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2023-08-28 9:31
 */
public class E08Leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
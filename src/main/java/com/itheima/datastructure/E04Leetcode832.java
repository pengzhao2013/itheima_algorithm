package com.itheima.datastructure;


import com.itheima.datastructure.linkedlist.ListNode;

/**
 * @author zpstart
 * @create 2023-08-27 12:00
 */
public class E04Leetcode832 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p2.val == p1.val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            return deleteDuplicates1(p.next);
        } else {
            p.next = deleteDuplicates1(p.next);
            return p;
        }
    }
}
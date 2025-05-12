package com.itheima.datastructure;

import com.itheima.datastructure.linkedlist.ListNode;

/**
 * @author zpstart
 * @create 2023-08-27 16:04
 */
public class E05Leetcode822 {
    public ListNode deleteDuplicates1(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            // x就是与p取值不同的节点
            return deleteDuplicates1(x);
        } else {
            p.next = deleteDuplicates1(p.next);
            return p;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2, p3;
        while ((p2 = p1.next) != null
                && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null
                        && (p3.val == p2.val)) {
                }
                // p3找到了不重复的值
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }
}

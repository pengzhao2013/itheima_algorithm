package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2023-08-19 13:06
 */
public class E04Leetcode83 {
    public ListNode deleteDuplicates1(ListNode head) {
        // 节点数 < 2
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                // 删除p2
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            return deleteDuplicates(p.next);
        } else {
            p.next = deleteDuplicates(p.next);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(3, null);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode head = new ListNode(1, node2);
        System.out.println(head);
        new E04Leetcode83().deleteDuplicates(head);
        System.out.println(head);
    }
}
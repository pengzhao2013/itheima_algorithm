package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2023-08-19 13:43
 */
public class E05Leetcode82 {
    public ListNode deleteDuplicates1(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            return deleteDuplicates(x); // x:与p取值不同的节点 以这个取值不同的节点递归结果为准
        } else {
            p.next = deleteDuplicates(p.next);
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
                        && p3.val == p2.val) {
                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(3, null);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode head = new ListNode(1, node2);
        System.out.println(head);
        System.out.println(new E05Leetcode82().deleteDuplicates(head));
    }
}
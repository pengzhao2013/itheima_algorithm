package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2023-08-06 21:00
 */
public class E03Leetcode19 {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        recursion(s, n);
        return s.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;
        // p2先走n + 1步
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }

    private int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        int nth = recursion(p.next, n); // 下一个节点的倒数位置
        System.out.println(p.val + " " + nth);
        if (nth == n) {
            p.next = p.next.next;
        }
        return nth + 1;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        System.out.println(head);
        System.out.println(new E03Leetcode19().removeNthFromEnd(head, 5));
    }
}
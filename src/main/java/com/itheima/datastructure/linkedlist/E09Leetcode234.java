package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2023-08-28 9:40
 */
public class E09Leetcode234 {
    /*
     * 1.找中间节点
     * 2.中间点之后半个链表翻转
     * 3.反转后链表与原链表逐一比较
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode middle = p1;

        ListNode n1 = null;
        while (middle != null) {
            ListNode o2 = middle.next;
            middle.next = n1;
            n1 = middle;
            middle = o2;
        }
        ListNode newHead = n1;

        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    /**
     * 方法五反转链表
     *
     * @author zpstart
     * @return com.itheima.datastructure.linkedlist.ListNode
     */
    private ListNode reverse(ListNode o1) {
        ListNode n1 = null;
        ListNode o2;
        while (o1 != null) {
            o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    /*
     * 1.找中间节点
     * 2.找中间点过程中反转前半个链表
     * 3.反转后链表与原链表逐一比较
     */
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode n1 = null;
        ListNode o1 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            // 反转链表代码
            // ListNode o2 = p1; // o2即p1 ListNode o2 = = o1.next
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        if (p2 != null) { // 奇数个节点 退出循环时快指针p2 不是null
            p1 = p1.next;
        }
        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }
}

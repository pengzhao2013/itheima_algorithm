package com.itheima.datastructure.linkedlist;


/**
 * @author zpstart
 * @create 2023-08-06 14:49
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append(",");
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static ListNode of(int... elements) {
        if (elements.length == 0) {
            return null;
        }
        ListNode p = null;
        for (int i = elements.length - 1; i >= 0; i--) {
            p = new ListNode(elements[i], p);
        }
        return p;
    }

    public ListNode append(ListNode last) {
        ListNode p = this;
        while (p.next != null) {
            p = p.next;
        }
        p.next = last;
        return this;
    }
}
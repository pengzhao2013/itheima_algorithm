package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2025-05-20 10:15
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode p1 = a;
        ListNode p2 = a;

        while (true) {
            if (p1 == p2) {
                return p1;
            }
            if (p1 == null) {
                p1 = b;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = a;
            } else {
                p2 = p2.next;
            }
        }
    }
}

package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2023-08-28 16:47
 */
public class E10Leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode h = head;
        ListNode t = head;
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
            if (h == t) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode h = head;
        ListNode t = head;
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
            if (h == t) {
                t = head;
                while (true) {
                    if (t == h) { // 如果龟回到起点，此时兔子也恰好在起点，就不用动了 此时就是第二次相遇 就是环的入口
                        return t;
                    }
                    t = t.next;
                    h = h.next;
                }
            }
        }
        return null;
    }
}

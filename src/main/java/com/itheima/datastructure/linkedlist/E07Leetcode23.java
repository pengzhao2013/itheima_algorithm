package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2023-08-27 22:47
 */
public class E07Leetcode23 {
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return s.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    /**
     * divide and conquer 分而治之 分 治:切分到最后问题能解决为止 合:把子问题的结果合并
     * decrease and conquer 减而治之 分而治之特例，单路递归 减小问题规模
     *
     * @author zpstart
     * @return ListNode
     */
    // 返回合并后的链表，i,j代表左右边界
    private ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) { // 数组内只有一个链表
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists(left, right);
    }
}

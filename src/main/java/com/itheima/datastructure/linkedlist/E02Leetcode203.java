package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2023-08-06 19:04
 */
public class E02Leetcode203 {
    public ListNode removeElements1(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p2.val == val) {
                // 删除,p2向后平移
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    public ListNode removeElements(ListNode p, int val) {
        if (p == null) {
            return null;
        }

        if (p.val == val) {
            return removeElements(p.next, val); // 若我与目标值相等,返回下一个节点的删除结果
        } else {
            // 若我与目标值不等,返回我,但我的next应该更新（让我能带上后续删过的节点）
            p.next = removeElements(p.next, val);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(7, null);
        ListNode node3 = new ListNode(7, node4);
        ListNode node2 = new ListNode(7, node3);
        ListNode node1 = new ListNode(7, node2);
        ListNode head = new ListNode(7, node1);
        System.out.println(head);
        System.out.println(new E02Leetcode203().removeElements(head, 7));
    }
}
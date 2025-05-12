package com.itheima.datastructure.linkedlist;

/**
 * @author zpstart
 * @create 2023-08-06 14:54
 */
public class E01Leetcode206 {
    public ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    public ListNode reverseList11(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode neweHead = new ListNode(head.val, null);
        ListNode p = head;
        while (p.next != null) {
            ListNode next = p.next;
            neweHead = new ListNode(next.val, neweHead);
            p = p.next;
        }
        return neweHead;
    }

    public ListNode reverseList2(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        while (true) {
            ListNode first = list1.removeFirst();
            if (first == null) {
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }

    public ListNode reverseList3(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode last = reverseList3(p.next); // 就为了返回最后一个节点，作为新链表的头节点
        p.next.next = p; // 相邻的两个节点逆序
        p.next = null;
        return last;
    }

    public ListNode reverseList4(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }
//        断开o2
        ListNode o2 = o1.next;
        ListNode n1 = o1;
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    public ListNode reverseList5(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = null; // 新链表 n1 = null
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    /**
     * 方法二：需要自己构造容器类
     */
    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new E01Leetcode206().reverseList5(o1);
        System.out.println(n1);
    }
}
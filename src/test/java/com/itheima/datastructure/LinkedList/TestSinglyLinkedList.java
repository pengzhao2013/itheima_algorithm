package com.itheima.datastructure.LinkedList;


import com.itheima.datastructure.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2023-07-30 9:05
 */
public class TestSinglyLinkedList {
    @Test
    public void test1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop1(System.out::println);
        list.loop2(System.out::println);
    }

    @Test
    public void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    public void test3() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        Assertions.assertIterableEquals(Arrays.asList(1, 2, 3, 4), list);
        System.out.println(list.get(3));
    }

    @Test
    @DisplayName("测试 insert")
    public void test4() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(5, 5);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试 removeFirst")
    public void test5() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }
        System.out.println("===================");
        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试 remove()")
    public void test6() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.remove(1);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试 testRecursion()")
    public void testRecursion() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.loop3(value -> System.out.println("before" + value),
        value -> System.out.println("after" + value));
    }
}

package com.itheima.datastructure.LinkedList;

import com.itheima.datastructure.linkedlist.SinglyLinkedListSentinel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author zpstart
 * @create 2025-04-26 19:23
 */
public class TestSinglyLinkedListSentinel {
    @Test
    @DisplayName("测试get")
    public void test3() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        assertThrows(IllegalArgumentException.class, () -> list.get(10));
    }
}

package com.itheima.datastructure.stack.exer;

import java.util.LinkedList;

/**
 * @author zpstart
 * @create 2025-05-02 22:42
 */
public class E04Leetcode232_2 {
    LinkedList<Integer> s1 = new LinkedList<>();
    LinkedList<Integer> s2 = new LinkedList<>();

    public void push(int x) {
        s2.push(x);
    }

    public int pop() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

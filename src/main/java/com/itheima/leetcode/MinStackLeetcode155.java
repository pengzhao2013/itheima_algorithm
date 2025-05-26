package com.itheima.leetcode;


import java.util.LinkedList;

/**
 * @Author : zpstart
 * @Date: 2025-05-26 16:31
 */
public class MinStackLeetcode155 {
    static class MinStack {
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();

        public MinStack() {
            min.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            min.push(Math.min(val, min.peek()));
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            stack.pop();
            min.pop();
        }

        public int top(int val) {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    static class MinStack2 {
        // jdk16新语法 get set toString hashcode 值是final的 不能更改
        record Data(int val, int min) {

        }
        LinkedList<Data> stack = new LinkedList<>();

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Data(val, val));
            } else {
                stack.push(new Data(val, Math.min(stack.peek().min, val)));
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            stack.pop();

        }

        public int top(int val) {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }
}

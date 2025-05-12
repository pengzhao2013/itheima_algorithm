package com.itheima.datastructure.stack.exer;

import java.util.Stack;

/**
 * @author zpstart
 * @create 2025-05-02 19:26
 */
public class E01Leetcode20_2 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    stack.push(')');
                    continue;
                case '[':
                    stack.push(']');
                    continue;
                case '{':
                    stack.push('}');
                    continue;
            }
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

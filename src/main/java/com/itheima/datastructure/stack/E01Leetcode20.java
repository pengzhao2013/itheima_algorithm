package com.itheima.datastructure.stack;

/**
 * @author zpstart
 * @create 2023-09-01 10:09
 */
public class E01Leetcode20 {
    public boolean isValid(String s) {// 遇到右括号 与栈顶比较
        ArrayStack<Character> stack = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (!stack.isEmpty() && c == stack.peek()) { // 尝试将null转为char
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        E01Leetcode20 e01Leetcode20 = new E01Leetcode20();
        System.out.println(e01Leetcode20.isValid("(([]]))"));
    }
}

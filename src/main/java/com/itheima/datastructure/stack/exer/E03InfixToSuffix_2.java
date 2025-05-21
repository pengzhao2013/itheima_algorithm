package com.itheima.datastructure.stack.exer;

import java.util.LinkedList;

/**
 * @author zpstart
 * @create 2025-05-20 17:49
 */
public class E03InfixToSuffix_2 {

    public static void main(String[] args) {
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("a*b+c"));
    }
    private static int priority(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("不合法的运算符:" + c);
        };
    }

    static String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] charArray = exp.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch (c) {
                case '+','-','*','/' -> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '(' -> stack.push(c);
                case ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default ->  sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}

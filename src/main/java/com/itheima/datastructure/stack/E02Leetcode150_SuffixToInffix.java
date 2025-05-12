package com.itheima.datastructure.stack;

import java.util.LinkedList;

/**
 * 遇到数字压入栈 遇到运算符出栈两个数字 运算结果再压入栈
 *
 * @author zpstart
 * @create 2023-09-01 10:50
 */
public class E02Leetcode150_SuffixToInffix {
    /*

        |   |
        | 13|
        | 4 |
        _____

        "4","13","5","/","+"

        - 遇到数字压入栈
        - 遇到运算符, 就从栈弹出两个数字做运算, 将结果压入栈
        - 遍历结束, 栈中剩下的数字就是结果
     */

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>(); // 实现了stack
        for (String t : tokens) {
            Integer b;
            Integer a;
            switch (t) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new E02Leetcode150_SuffixToInffix().evalRPN(tokens));
    }
}

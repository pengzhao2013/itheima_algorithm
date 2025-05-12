package com.itheima.datastructure.binarytree.exer;

import java.util.LinkedList;

/**
 * @author zpstart
 * @create 2025-05-04 16:29
 */
public class E08ExpressionTree {
    public static void main(String[] args) {
        String[] tokens = new String[] {"5","8","-","2","*"};
        TreeNode treeNode = constructExpressionTree(tokens);
        System.out.println(treeNode);
    }
    static class TreeNode {
        public String val;

        public TreeNode left;

        public TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, String val, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return this.val;
        }
    }

    /*
        中缀表达式           (2-1)*3
        后缀（逆波兰）表达式   21-3*

        1.遇到数字入栈
        2.遇到运算符, 出栈两次, 先出栈的是右节点,与当前节点建立父子关系, 当前节点入栈
        验证：后序遍历结果与后缀表达式一致

        栈
        |   |
        |   |
        |   |
        _____

        表达式树
            *
           / \
          -   3
         / \
        2   1

        21-3*
     */
    public static TreeNode constructExpressionTree(String[] tokens) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+":
                case "-":
                case "*":
                case "/":
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode parent = new TreeNode(t);
                    parent.left = left;
                    parent.right = right;
                    stack.push(parent);
                    break;
                default: // 数字
                    stack.push(new TreeNode(t));
            }
        }
        return stack.peek();
    }
}

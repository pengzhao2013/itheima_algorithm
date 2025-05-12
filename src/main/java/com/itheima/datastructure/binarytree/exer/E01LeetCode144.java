package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-04 10:02
 */
public class E01LeetCode144 {
    public static void main1(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                integers.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
        return integers;
    }

    public static void main0(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                colorPrintln("去:" + curr.val, 31);
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                colorPrintln("回:" + pop.val, 34);
                curr = pop.right;
            }
        }
    }

    public static void main(String[] args) { // leetcode 144 94 145
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pop = null; // 最近一次弹栈的元素
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                colorPrintln("前:" + curr.val, 31);
                curr = curr.left; // 待处理左子树
            } else {
                TreeNode peek = stack.peek(); // 未处理右子树之前不能弹出
                if (peek.right == null) { // 没有右子树
                    colorPrintln("中:" + peek.val, 36);
                    pop = stack.pop();
                    colorPrintln("后:" + pop.val, 34); // 没有右子树 弹栈之后
                } else if (peek.right == pop) {
                    pop = stack.pop(); // 右子树已经处理完了
                    colorPrintln("后:" + pop.val, 34);
                } else {
                    colorPrintln("中:" + peek.val, 36);
                    curr = peek.right; // 待处理右子树
                }
            }
        }
    }

    /*
        31 红
        32 黄
        33 橙
        34 蓝
        35 紫
        36 绿
     */
    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}

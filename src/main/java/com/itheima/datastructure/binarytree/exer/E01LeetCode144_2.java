package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-04 12:26
 */
public class E01LeetCode144_2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
//        System.out.println(preorderTraversal1(root));
        System.out.println(preorderTraversal2(root));
    }
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public static void preOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        preOrder(treeNode.left, list);
        preOrder(treeNode.right, list);
    }

    /**
     * 方法二：迭代
     * @author zpstart
     * @return java.util.List<java.lang.Integer>
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                result.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    pop = stack.pop();
                } if (peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return result;
    }
}

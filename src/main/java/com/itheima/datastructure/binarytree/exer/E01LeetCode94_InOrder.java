package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-04 12:50
 */
public class E01LeetCode94_InOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
//        System.out.println(inorderTraversal1(root));
        System.out.println(inorderTraversal2(root));
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private static void inOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left, list);
        list.add(treeNode.val);
        inOrder(treeNode.right, list);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    pop = stack.pop();
                    result.add(pop.val);
                } else if (peek.right == pop) {
                    pop = stack.pop();
                } else {
                    result.add(peek.val);
                    curr = peek.right;
                }
            }
        }
        return result;
    }
}

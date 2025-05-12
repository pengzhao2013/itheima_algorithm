package com.itheima.datastructure.binarysearchtree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-05 21:07
 */
public class E02Leetcode701 {
    public TreeNode insertIntoBSTRecursion(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val < val) {
            node.right = insertIntoBSTRecursion(node.right, val);
        } else {
            node.left = insertIntoBSTRecursion(node.left, val);
        }
        return node;
    }

    public TreeNode insertIntoBSTNotRecursion(TreeNode root, int val) {
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null) {
            if (p.val < val) {
                parent = p;
                p = p.right;
            } else {
                parent = p;
                p = p.left;
            }
        }
        if (parent == null) {
            return new TreeNode(val);
        }
        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
        return root;
    }
}

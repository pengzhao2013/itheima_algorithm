package com.itheima.datastructure.binarysearchtree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-05 21:24
 */
public class E03Leetcode700SearchNode {
    public TreeNode searchBSTRecursion(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val < val) {
            return searchBSTRecursion(node.right, val);
        } else if (node.val > val) {
            return searchBSTRecursion(node.left, val);
        } else {
            return node;
        }
    }

    public TreeNode searchBSTNotRecursion(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode p = root;
        while (p != null) {
            if (p.val < val) {
                p = p.right;
            } else if (p.val > val) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }
}

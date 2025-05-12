package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-04 16:12
 */
public class E07Leetcode226_Fn {
    public static TreeNode invertTree(TreeNode root) {
        fn(root);
        return root;
    }

    private static void fn(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        fn(node.left);
        fn(node.right);
    }
}

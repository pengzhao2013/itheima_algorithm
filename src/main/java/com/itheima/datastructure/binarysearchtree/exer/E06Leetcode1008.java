package com.itheima.datastructure.binarysearchtree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-06 22:00
 */
public class E06Leetcode1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private TreeNode insert(TreeNode node, int val) { // O(nlog(n))
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val < val) {
            node.right = insert(node.right, val);
        } else {
            node.left = insert(node.left, val);
        }
        return node;
    }
}

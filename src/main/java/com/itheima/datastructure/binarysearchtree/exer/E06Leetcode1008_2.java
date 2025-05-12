package com.itheima.datastructure.binarysearchtree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-09 10:21
 */
public class E06Leetcode1008_2 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return insert(preorder, Integer.MAX_VALUE);
    }

    int i = 0;

    private TreeNode insert(int[] preorder, int max) {
        if (i == preorder.length) {
            return null;
        }
        int val = preorder[i];
        if (val > max) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        i++;
        node.left = insert(preorder, val);
        node.right = insert(preorder, max);
        return node;
    }
}

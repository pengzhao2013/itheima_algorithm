package com.itheima.datastructure.binarysearchtree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-09 11:05
 */
public class E06Leetcode1008_3 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return partition(preorder, 0, preorder.length - 1);
    }

    /**
     *
     * @author zpstart
     */
    private TreeNode partition(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        while (index <= end) {
            if (preorder[index] > preorder[start]) {
                break;
            }
            index++;
        }
        root.left = partition(preorder, start + 1, index - 1);
        root.right = partition(preorder, index, end);
        return root;
    }
}

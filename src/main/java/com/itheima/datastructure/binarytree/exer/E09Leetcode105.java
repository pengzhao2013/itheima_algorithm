package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.Arrays;

/**
 * 前序中序遍历结果构造二叉树
 * @author zpstart
 * @create 2025-05-04 18:10
 */
public class E09Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                int[] inLeft = Arrays.copyOfRange(inorder, 0 , i);// 不包含i
                int[] inRight = Arrays.copyOfRange(inorder, i + 1 , inorder.length);

                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }
}

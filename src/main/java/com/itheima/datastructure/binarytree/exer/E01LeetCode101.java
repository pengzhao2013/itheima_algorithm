package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-04 13:40
 */
public class E01LeetCode101 {
    public static boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left, root.right);
    }

    private static boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }
}

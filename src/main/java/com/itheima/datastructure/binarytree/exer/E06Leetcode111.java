package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-04 15:42
 */
public class E06Leetcode111 {
    public static int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int d1 = minDepth(node.left);
        int d2 = minDepth(node.right);
        if (d2 == 0) { // 当左子树为null，返回右子树深度 + 1
            return d1 + 1;
        }
        if (d1 == 0) {
            return d2 + 1;
        }
        return Integer.min(d1, d2) + 1;
    }
}

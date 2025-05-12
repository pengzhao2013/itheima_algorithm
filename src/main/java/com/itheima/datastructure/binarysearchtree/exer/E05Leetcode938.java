package com.itheima.datastructure.binarysearchtree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @author zpstart
 * @create 2025-05-06 20:52
 */
public class E05Leetcode938 {
    /**
     * 中序非递归
     * @author zpstart
     * @return int
     */
    public int rangeSumBSTNotRecursion(TreeNode root, int low, int high) {
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop.val > high) {
                    break;
                }
                if (pop.val >= low) {
                    sum += pop.val;
                }
                curr = pop.right;
            }
        }
        return sum;
    }

    /**
     * 上下限递归
     * @author zpstart
     * @return int
     */
    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val < low) {
            return rangeSumBST(node.right, low, high);
        }
        if (node.val > high) {
            return rangeSumBST(node.left, low, high);
        }
        return node.val + rangeSumBST(node.left, low, high) +
                rangeSumBST(node.right, low, high);
    }
}

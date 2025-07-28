package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @Author: zpstart
 * @Date: 2025-07-27 11:40
 * @Description:
 */
public class LeetCode404_SumLeftLeaves {
    /**
     * 递归
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);
        int midValue = 0;
        if (root.left != null && root.left.left == null &&
                root.left.right == null) {
            midValue = root.left.val;
        }
        return midValue + leftValue + rightValue;
    }

    /**
     * 迭代
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                if (curr.left != null && curr.left.left == null &&
                        curr.left.right == null) {
                    sum += curr.left.val;
                }
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
        return sum;
    }

    /**
     * 层序遍历
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    if (poll.left.left == null && poll.left.right == null){ // 左叶子节点
                        sum += poll.left.val;
                    }
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return sum;
    }
}

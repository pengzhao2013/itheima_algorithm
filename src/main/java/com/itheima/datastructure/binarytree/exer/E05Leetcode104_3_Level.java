package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zpstart
 * @create 2025-05-04 14:45
 */
public class E05Leetcode104_3_Level {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
//        System.out.println(preorderTraversal1(root));
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll.val + "\t");
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            maxDepth++;
            System.out.println();
        }
        return maxDepth;
    }
}

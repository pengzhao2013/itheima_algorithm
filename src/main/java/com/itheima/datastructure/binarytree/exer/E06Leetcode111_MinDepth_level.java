package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历时遇到的第一个叶子节点所在层就是最小深度
 * @author zpstart
 * @create 2025-05-04 15:49
 */
public class E06Leetcode111_MinDepth_level {
    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
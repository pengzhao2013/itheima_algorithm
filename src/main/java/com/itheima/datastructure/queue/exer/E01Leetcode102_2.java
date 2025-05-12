package com.itheima.datastructure.queue.exer;

import com.itheima.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-02 18:23
 */
public class E01Leetcode102_2 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) { // 没有节点
            return result;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        int c1 = 1;
        while (!linkedList.isEmpty()) {
            int c2 = 0;
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < c1; i++) {
                TreeNode treeNode = linkedList.poll();
                if (treeNode.left != null) {
                    linkedList.offer(treeNode.left);
                    c2++;
                }
                if (treeNode.right != null) {
                    linkedList.offer(treeNode.right);
                    c2++;
                }
                level.add(treeNode.val);
            }
            result.add(level);
            c1 = c2;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
        System.out.println(levelOrder(root));
    }
}

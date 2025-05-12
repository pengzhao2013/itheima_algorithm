package com.itheima.datastructure.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author zpstart
 * @create 2023-08-31 17:44
 */
public class E01Leetcode102 {// jdk队列：LinkedList-双端队列
    public static List<List<Integer>> levelOrder(TreeNode root) { // 按树结构输出
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) { // 没有节点
            return result;
        }
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);
//                System.out.print(n + " ");
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            result.add(level);
//            System.out.println(); // 换行
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
//        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode n = queue.poll();
//            System.out.print(n + " ");
//            if (n.left != null) {
//                queue.offer(n.left);
//            }
//            if (n.right != null) {
//                queue.offer(n.right);
//            }
//        }
    }
}
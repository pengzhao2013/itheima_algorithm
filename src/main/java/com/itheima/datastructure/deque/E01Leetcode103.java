package com.itheima.datastructure.deque;

import com.itheima.datastructure.queue.LinkedListQueue;
import com.itheima.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-03 10:14
 */
public class E01Leetcode103 {
    public static List<List<Integer>> levelOrder(TreeNode root) { // 按树结构输出
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) { // 没有节点
            return result;
        }
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        boolean odd = true;
        while (!queue.isEmpty()) {
            // 不要用List接收
            LinkedList<Integer> level = new LinkedList<>(); //jdk自带的ArrayDeque/LinkedList
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                if (odd) {
                    level.offerLast(n.val);
                } else {
                    level.offerFirst(n.val);
                }
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
            odd = !odd;
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

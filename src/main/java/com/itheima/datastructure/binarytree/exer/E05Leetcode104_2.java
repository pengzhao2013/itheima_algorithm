package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * 后序遍历记录栈的最大深度
 *
 * @author zpstart
 * @create 2025-05-04 14:31
 */
public class E05Leetcode104_2 {
    /**
     * 使用非递归后序遍历,栈的最大高度即为最大深度
     *
     * @return int
     * @author zpstart
     */
    public static int maxDepth(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        TreeNode pop = null;
        int max = 0;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                int size = stack.size();
                if (size > max) {
                    max = size;
                }
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }
}

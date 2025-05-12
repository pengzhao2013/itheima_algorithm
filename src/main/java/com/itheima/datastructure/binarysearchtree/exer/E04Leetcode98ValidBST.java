package com.itheima.datastructure.binarysearchtree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zpstart
 * @create 2025-05-05 21:43
 */
public class E04Leetcode98ValidBST {
    public boolean isValidBSTNotRecursion(TreeNode root) {
        TreeNode curr = root;
        long prev = Long.MIN_VALUE;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                if (prev >= pop.val) {
                    return false;
                }
                prev = pop.val;
                curr = pop.right;
            }
        }
        return true;
    }

//    private long prev = Long.MIN_VALUE;
//    public boolean isValidBST2(TreeNode node) {
//        if (node == null) {
//            return true;
//        }
//        boolean a = isValidBST2(node.left);
//        if (!a) {
//            return false;
//        }
//        if (prev >= node.val) {
//            return false;
//        }
//        prev = node.val;
//        return isValidBST2(node.right);
//    }
    /**
     *  Long、Integer:不可变参数，不可作为传参
     * @author zpstart
     * @return boolean
     */
    public boolean isValidBST3(TreeNode node) {
        return doValid3(node, new AtomicLong(Long.MIN_VALUE));
    }

    private boolean doValid3(TreeNode node, AtomicLong prev) {
        if (node == null) {
            return true;
        }
        boolean a = doValid3(node.left, prev);
        if (!a) {
            return false;
        }
        if (prev.get() >= node.val) {
            return false;
        }
        prev.set(node.val);
        return doValid3(node.right, prev);
    }

    public boolean isValidBST4(TreeNode node) {
        return doValid4(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doValid4(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return doValid4(node.left, min, node.val) && doValid4(node.right, node.val, max);
    }
}

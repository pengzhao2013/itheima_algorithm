package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-04 13:17
 */
public class E01LeetCod145_PostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
//        System.out.println(postorderTraversal1(root));
        System.out.println(postorderTraversal2(root));
    }
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left, result);
        postOrder(treeNode.right, result);
        result.add(treeNode.val);
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    pop = stack.pop();
                    result.add(pop.val);
                } else if (peek.right == pop) {
                    pop = stack.pop();
                    result.add(pop.val);
                } else {
                    curr = peek.right;
                }
            }
        }
        return result;
    }
}

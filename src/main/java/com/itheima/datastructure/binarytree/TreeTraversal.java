package com.itheima.datastructure.binarytree;

/**
 * @author zpstart
 * @create 2025-05-03 23:04
 */
public class TreeTraversal {
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        preOrder(root);
        System.out.println();

        inOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();
    }

    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + "\t");
        inOrder(node.right);
    }

    /**
     * <h3>后序遍历</h3>
     * @param node 节点
     */
    static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left); // 左
        postOrder(node.right); // 右
        System.out.print(node.val + "\t"); // 值
    }
}

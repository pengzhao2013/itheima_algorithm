package com.itheima.datastructure.binarysearchtree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-05 19:49
 */
public class E01Leetcode450 {
    public TreeNode deleteNodeRecursion(TreeNode root, int key) {
        root = delete(root, key);
        return root;
    }

    private TreeNode delete(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.val < key) {
            node.right = delete(node.right, key); // 返回的是删除之后剩下的孩子节点
            return node;
        }
        if (node.val > key) {
            node.left = delete(node.left, key);
            return node;
        }
        if (node.left == null) {
            return node.right;
        }
        if (node.right == null) {
            return node.left;
        }

        // 有左右子节点情况
        // 1.找被删除节点后继节点
        TreeNode s = node.right;
        while (s.left != null) {
            s = s.left;
        }
        // 2.在被删除节点右子树中删除后继节点
        s.right = delete(node.right, s.val);
        s.left = node.left;
        return s;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(null, 2, null);
        TreeNode treeNode4 = new TreeNode(null, 4, null);
        TreeNode treeNode7 = new TreeNode(null, 7, null);
        TreeNode treeNode3 = new TreeNode(treeNode2, 3, treeNode4);
        TreeNode treeNode6 = new TreeNode(null, 6, treeNode7);
        TreeNode treeNode5 = new TreeNode(treeNode3, 5, treeNode6);
        System.out.println(deleteNodeNotRecursion(treeNode5, 0));
    }

    public static TreeNode deleteNodeNotRecursion(TreeNode root, int key) {
        // 1.寻找被删除节点
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null) {
            if (p.val < key) {
                parent = p;
                p = p.right;
            } else if (p.val > key){
                parent = p;
                p = p.left;
            } else {
                break;
            }
        }
        if (p == null) {
            return root;
        }

        // 情况1:只有右子树
        if (p.left == null) {
            if (parent == null) {
                root = p.right;
            } else {
                shift(parent, p, p.right);
            }
        } else if (p.right == null) {// 情况2:只有左子树
            if (parent == null) {
                root = p.left;
            } else {
                shift(parent, p, p.left);
            }
        } else {
            // 情况3：有左右子树
            // 找后继节点
            TreeNode s = p.right;
            TreeNode sParent = p;
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            if (s != p.right) {
                shift(sParent, s, s.right);
                s.right = p.right;
            }

            if (parent == null) {
                root = s;
            } else {
                shift(parent, p, s);
            }
            s.left = p.left;
        }
        return root;
    }

    /**
     * 托孤方法
     * @author zpstart
     * @return
     */
    private static void shift(TreeNode parent, TreeNode node, TreeNode child) {
        if (node == parent.left){
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
}

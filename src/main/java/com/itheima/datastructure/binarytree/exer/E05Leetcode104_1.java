package com.itheima.datastructure.binarytree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * @author zpstart
 * @create 2025-05-04 14:03
 */
public class E05Leetcode104_1 {
    /*
        思路：
        1. 得到左子树深度, 得到右子树深度, 二者最大者加一, 就是本节点深度
        2. 因为需要先得到左右子树深度, 很显然是后序遍历典型应用
        3. 关于深度的定义：从根(也可以是某节点)出发, 离根最远的节点总边数,
            注意: 力扣里的深度定义要多一

            深度2         深度3        深度1
            1            1            1
           / \          / \
          2   3        2   3
                            \
                             4
     */
    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int d1 = maxDepth(node.left);
        int d2 = maxDepth((node.right));
        return Integer.max(d1, d2) + 1; // 本层的深度 = 子树最大深度 + 1
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(
                        new TreeNode(14), 6, new TreeNode(17)))
        );
        System.out.println(maxDepth(root));
    }
}

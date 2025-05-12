package com.itheima.datastructure.binarysearchtree.exer;

import com.itheima.datastructure.binarytree.TreeNode;

/**
 * 最近公共祖先
 * @author zpstart
 * @create 2025-05-09 20:35
 */
public class E07Leetcode235 {
    /*
            __ 6 __
           /       \
          2         8
         / \       / \
        0   4     7   9
           / \
          3   5

          待查找节点 p q 在某一节点的两侧，那么此节点就是最近的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root;
        // p跟q在当前节点同一侧
        while (p.val < a.val && q.val < a.val || p.val > a.val && q.val > a.val) {
            if (p.val < a.val) {
                a = a.left;
            } else {
                a = a.right;
            }
        }
        return a;
    }
}

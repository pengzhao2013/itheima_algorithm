package com.itheima.datastructure.avltree;

import com.google.errorprone.annotations.Var;

/**
 * @author zpstart
 * @create 2025-05-09 21:03
 */
public class AVLTree {
    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key) {
            this.key = key;
        }

        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 求节点高度
     *
     * @return int
     */
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 更新节点高度
     *
     * @return int
     */
    private void updateHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    // 平衡因子 balance factor = 左子树高度-右子树高度 <=1 平衡
    private int bf(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    // 0 1 -1 平衡 >1 <-1 不平衡
    // 参数：要旋转的节点 返回值:新的根节点
    private AVLNode rightRotate(AVLNode red) {
        AVLNode yellow = red.left; // 右旋肯定左边高，yellow不等于null
        red.left = yellow.right;
        yellow.right = red; // 上位
//        red.left = green; // 换爹
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    private AVLNode leftRotate(AVLNode red) {
        AVLNode yellow = red.right;
        red.right = yellow.left;
        yellow.left = red;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    /*
     * node:失衡节点
     * @author zpstart
     */
    private AVLNode leftRightRotate(AVLNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private AVLNode rightLeftRotate(AVLNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    /**
     * 检查节点是否失衡 重新平衡代码
     *
     * @author zpstart
     */
    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }
        int bf = bf(node);
        if (bf > 1 && bf(node.left) >= 0) { // LL
            return rightRotate(node);
        } else if (bf > 1 && bf(node.left) < 0) { // LR
            return leftRightRotate(node);
        } else if (bf < -1 && bf(node.right) > 0) { // RL
            return rightLeftRotate(node);
        } else if (bf < -1 && bf(node.right) <= 0) { // RR
            return leftRotate(node);
        }
        return node;
    }

    AVLNode root;

    public void put(int key, Object value) {
        root = doPut(root, key, value);
    }

    private AVLNode doPut(AVLNode node, int key, Object value) {
        if (node == null) {
            return new AVLNode(key, value);
        }
        // 2.key已存在,更新
        if (key == node.key) {
            node.value = value;
            return node;
        }
        // 3.继续查找 找到空位添加
        if (key < node.key) {
            node.left = doPut(node.left, key, value);
        } else {
            node.right = doPut(node.right, key, value);
        }
        updateHeight(node); // 递归回去的时候一点一点更新每个节点的高度
        return balance(node);
    }

    public void remove(int key) {
        root = doRemove(root, root.key);
    }

    private AVLNode doRemove(AVLNode node, int key) {
        // 1. node == null
        if (node == null) {
            return null;
        }
        // 2. 没找到 key
        if (key < node.key) {
            // 返回的是删剩下的
            node.left = doRemove(node.left, key);
        } else if (key > node.key) {
            node.right = doRemove(node.right, key);
        } else {
            // 3. 找到 key  1) 没有孩子 2) 只有一个孩子 3) 有两个孩子
            if (node.left == null) {
                node = node.right; // 后面还要处理高度
            } else if (node.right == null) {
                node = node.left;
            } else {
                // 找后继节点
                AVLNode s = node.right;
                while (s.left != null) {
                    s = s.left;
                }
                // s 后继节点
                s.right = doRemove(node.right, s.key);
                s.left = node.left;
                node = s; // 删剩下的是后继节点 后面更新后继节点高度 和balance
            }
        }

        // 4. 更新高度
        updateHeight(node);
        // 5.balance
        balance(node);
        return node;
    }
}

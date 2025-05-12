package com.itheima.datastructure.btree;

import java.util.Arrays;

/**
 * @author zpstart
 * @create 2025-05-11 10:18
 */
public class BTree {
    static class Node {
        int[] keys;

        Node[] children;
        
        /**
         * 有效关键字数目
         */
        int keyNumber;

        /**
         * 是否叶子节点 一开始默认是
         */
        boolean leaf = true;

        /**
         * 最小度数
         */
        int t;

        public Node(int t) {
            this.t = t; // >= 2
            this.children =  new Node[2 * t];
            this.keys = new int[2 * t - 1];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }
        // 多路查找
        Node get(int key) {
            int i = 0;
            while (i < keyNumber) {
                if (keys[i] == key) {
                    return this;
                }
                if (keys[i] > key) {
                    break;
                }
                i++;
            }
            // 执行到此时 keys[i]>key 或 i==keyNumber
            if (leaf) {
                return null;
            }
            // 非叶子情况
            return children[i].get(key);
        }

        // 向 keys 指定索引处插入 key
        void insertKey(int key, int index) {
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }

        // 向 children 指定索引处插入 child
        void insertChild(Node child, int index) {
            System.arraycopy(children, index, children, index + 1,
                    keyNumber - index); // keyNumber - 1 - index + 1
            children[index] = child;
        }

        // 移除指定 index 处的 key
        int removeKey(int index) {
            int t = keys[index];
            System.arraycopy(keys, index + 1, keys, index, --keyNumber - index);
            return t;
        }

        // 移除最左边的 key
        int removeLeftmostKey() {
            return removeKey(0);
        }

        // 移除最右边的 key
        int removeRightmostKey() {
            return removeKey(keyNumber - 1);
        }

        // 移除指定 index 处的 child
        Node removeChild(int index) {
            Node t = children[index];
            System.arraycopy(children, index + 1, children, index, keyNumber - index);
            children[keyNumber] = null; // help GC
            return t;
        }

        // 移除最左边的 child
        Node removeLeftmostChild() {
            return removeChild(0);
        }

        // 移除最右边的 child
        Node removeRightmostChild() {
            return removeChild(keyNumber);
        }

        // index 孩子处左边的兄弟
        Node childLeftSibling(int index) {
            return index > 0 ? children[index - 1] : null;
        }

        // index 孩子处右边的兄弟
        Node childRightSibling(int index) {
            return index == keyNumber ? null : children[index + 1];
        }

        // 复制当前节点的所有 key 和 child 到 target
        void moveToTarget(Node target) {
            int start = target.keyNumber;
            if (!leaf) {
                for (int i = 0; i <= keyNumber; i++) {
                    target.children[start + i] = children[i];
                }
            }
            for (int i = 0; i < keyNumber; i++) {
                target.keys[target.keyNumber++] = keys[i];
            }
        }
    }

    Node root;

    int t; // 树中节点的最小度数 最大度数2 * t

    final int MIN_KEY_NUMBER; // 最小key数目 以后不能变了

    final int MAX_KEY_NUMBER; // 最大key数目

    public BTree() {
        this(2);
    }

    public BTree(int t) {
        this.t = t;
        root = new Node(t);
        MAX_KEY_NUMBER = 2 * t - 1;
        MIN_KEY_NUMBER = t - 1;
    }

    // 1. 是否存在
    public boolean contains(int key) {
        return root.get(key) != null;
    }

    public void put(int key) {
        doPut(root, key, null, 0);
    }

    /**
     * 一个节点中数目达到2*t-1时要分裂
     * @author zpstart
     * @return void
     */
    private void doPut(Node node, int key, Node parent, int index) {
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] == key) {
                return; // 更新
            }
            if (node.keys[i] > key) {
                break; // 找到了插入位置，即为此时的 i
            }
            i++;
        }
        if (node.leaf) {
            node.insertKey(key, i);
            // 上限

        } else {
            doPut(node.children[i], key, node, i);
        }
        if (node.keyNumber == MAX_KEY_NUMBER) {
            split(node, parent, index);
        }
    }

    /**
     * 功能描述
     * @author zpstart
     * @param left 分裂后作为左边的孩子
     * index 被分裂节点是第几个孩子
     * @return void
     */
    private void split(Node left, Node parent, int index) {
        if (parent == null) {
            // 分裂的是根节点分裂的是根节点
            Node newRoot = new Node(t);
            newRoot.leaf = false;
            newRoot.insertChild(left, 0);
            this.root = newRoot;
            parent = newRoot;
        }

        // 1. 创建 right 节点，把 left 中 t 之后的 key 和 child 移动过去
        Node right = new Node(t);
        right.leaf = left.leaf;
        System.arraycopy(left.keys, t, right.keys, 0, t - 1);
        if (!left.leaf) {
            // 把孩子节点也拷贝到新节点
            System.arraycopy(left.children, t, right.children, 0, t); // children数组比父节点keys数组长度多一个
        }

        right.keyNumber = t - 1;
        left.keyNumber = t - 1;

        // 2. 中间的 key （t-1 处）插入到父节点
        int mid = left.keys[t - 1];
        parent.insertKey(mid, index);
        parent.insertChild(right, index + 1);
    }
}

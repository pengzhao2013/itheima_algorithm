package com.itheima.datastructure.binarysearchtree;

/**
 * @author zpstart
 * @create 2025-05-05 10:55
 */
public class BSTTree2_1<K extends Comparable<K>, V> {
    BSTNode<K, V> root;

    static class BSTNode<K, V> {
        K key;

        V value;

        BSTNode<K, V> left;

        BSTNode<K, V> right;

        public BSTNode(K key) {
            this.key = key;
        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        BSTNode<K, V> p = root;
        while (p != null) {
            // -1 key < p.key 0: 相等 1:前一个 > 后一个
            int result = key.compareTo(p.key);
            if (result < 0) {
                p = p.left;
            } else if (result > 0) {
                p = p.right;
            } else {
                return p.value;
            }
        }
        return null;
    }


    public Object min() {
        return null;
    }

    public Object max() {
        return null;
    }

    public void put(int key, Object value) {

    }

    public Object successor(int key) {
        return null;
    }

    public Object predecessor(int key) {
        return null;
    }

    public Object delete(int key) {
        return null;
    }
}

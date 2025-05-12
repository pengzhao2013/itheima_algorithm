package com.itheima.datastructure.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-04 19:12
 */
public class BSTTree1 {
    BSTNode root;

    static class BSTNode {
        int key;

        Object value;

        BSTNode left;

        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public Object get(int key) {
//        return doGet(root, key);
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    /**
     * <h3>查找最小关键字对应值</h3>
     *
     * @return 关键字对应的值
     */
    public Object min() {
//        return doMin(root);
        return min(root);
    }

    private Object min(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    private Object doMin(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) { //
            return node.value;
        }
        return doMin(node);
    }

    public Object max() {
        return max(root);
    }

    private Object max(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    /**
     * <h3>存储关键字和对应值</h3>
     *
     * @param key   关键字
     * @param value 值
     */
    public void put(int key, Object value) {
//        root = doPut(root, key, value);
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            parent = node;
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                node.value = value;
                return;
            }
        }
        // key 没有新增
        if (parent == null) {
            root = new BSTNode(key, value);
        }
        if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else {
            parent.right = new BSTNode(key, value);
        }
    }

//    private BSTNode doPut(BSTNode node, int key, Object value) {
//        if (node == null) {
//            return new BSTNode(key, value);
//        }
//        if (key < node.key) {
//            node.left = doPut(node.left, key, value);
//        } else if (node.key < key) {
//            node.right = doPut(node.right, key, value);
//        } else {
//            node.value = value;
//        }
//        return node;
//    }

    /**
     * <h3>查找关键字的后任值</h3>
     *
     * @param key 关键字
     * @return 后任值
     */
    public Object successor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while (p != null) {
            if (key < p.key) {
                ancestorFromRight = p;
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                break;
            }
        }
        // 没找到节点
        if (p == null) {
            return null;
        }
        // 找到节点 情况1：节点有右子树，此时后任就是右子树的最小值
        if (p.right != null) {
            return min(p.right);
        }
        // 找到节点 情况2：节点没有右子树，若离它最近的、自右而来的祖先就是后任
        return ancestorFromRight != null ?
                ancestorFromRight.value : null;
    }

    /**
     * <h3>查找关键字的前任值</h3>
     *
     * @param key 关键字
     * @return 前任值
     */
    public Object predecessor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromLeft = null;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                ancestorFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }
        // 没找到节点
        if (p == null) {
            return null;
        }
        // 找到节点 情况1：节点有左子树，此时前任就是左子树的最大值
        if (p.left != null) {
            return max(p.left);
        }
        // 找到节点 情况2：节点没有左子树，若离它最近的、自左而来的祖先就是前任
        return ancestorFromLeft != null ?
                ancestorFromLeft.value : null;
    }

    public Object delete(int key) {
        BSTNode p = root;
        BSTNode parent = null;
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (p.key < key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        // 删除操作
        if (p.left == null) {
            shift(parent, p, p.right); // 情况1
        } else if (p.right == null) {
            shift(parent, p, p.left); // 情况2
        } else {
            // 情况4
            // 4.1 被删除节点找后继
            BSTNode s = p.right;
            BSTNode sParent = p; // 后继父亲
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // 后继节点即为 s
            if (sParent != p) { // 不相邻
                // 4.2 删除和后继不相邻, 处理后继的后事
                shift(sParent, s, s.right); // 不可能有左孩子
                s.right = p.right;
            }
            // 4.3 后继取代被删除节点
            shift(parent, p, s);
            s.left = p.left;
        }
        return p.value;
    }

    /**
     * 托孤方法
     *
     * @param parent  被删除节点的父亲
     * @param deleted 被删除节点
     * @param child   被顶上去的节点
     */
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) { // 删除的是根节点
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

//    private Object doGet(BSTNode node, int key) {
//        if (node == null) {
//            return null;
//        }
//        if (key < node.key) {
//            return doGet(node.left, key);
//        } else if (node.key < key) {
//            return doGet(node.right, key);
//        } else {
//            return node.value;
//        }
//    }

    /*
                 4
               /   \
              2     6
             / \   / \
            1   3 5   7
     */

    // 找 < key 的所有 value 二叉搜索树中序遍历结果为从小到大排序
    public List<Object> less(int key) { // key=6
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key < key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    // 找 > key 的所有 value
    public List<Object> greater(int key) {
        /*ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key > key) {
                    result.add(pop.value);
                }
                p = pop.right;
            }
        }
        return result;*/

        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key > key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }

    // 找 >= key1 且 <= key2 的所有值
    public List<Object> between(int key1, int key2) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.value);
                } else if (pop.key > key2) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }
}

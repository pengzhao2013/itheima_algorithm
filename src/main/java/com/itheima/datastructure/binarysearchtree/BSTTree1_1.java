package com.itheima.datastructure.binarysearchtree;

import com.itheima.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-05 9:31
 */
public class BSTTree1_1 {
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
            if (node.key < key) {
                node = node.right;
            } else if (node.key > key) {
                node = node.left;
            } else {
                return node.value;
            }
        }
        return null;
    }

    /**
     * 递归查询
     *
     * @return java.lang.Object
     * @author zpstart
     */
    private Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            return doGet(node.left, key);
        } else if (node.key < key) {
            return doGet(node.right, key);
        } else {
            return node.value;
        }
    }

    public Object min() {
//        return doMin(root);
        return min(root);
    }

    private Object min(BSTNode node) {
//        return doMin(root);
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
        if (node.left == null) {
            return node.value;
        }
        return doMin(node.left);
    }

    public Object max() {
//        return doMax(root);
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

    private Object doMax(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.value;
        }
        return doMax(node.right);
    }

    public void put(int key, Object value) {
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            if (node.key < key) {
                parent = node;
                node = node.right;
            } else if (node.key > key) {
                parent = node;
                node = node.left;
            } else {
                node.value = value;
                return;
            }
        }

        if (parent == null) {
            root = new BSTNode(key, value);
            return;
        }
        if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else {
            parent.right = new BSTNode(key, value);
        }
    }

    public Object successor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while (p != null) {
            if (key < p.key) {
                ancestorFromRight = p;
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        // 找到节点 情况1：节点有右子树，此时后任就是右子树的最小值
        if (p.right != null) {
            return min(p.right);
        }
        // 找到节点 情况2：节点没有右子树，若离它最近的、自右而来的祖先就是后任
        return ancestorFromRight == null ?
                null : ancestorFromRight.value;
    }

    public Object predecessor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromLeft = null;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                ancestorFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        // 找到节点 情况1：节点有左子树，此时前任就是左子树的最大值
        if (p.left != null) {
            return max(p.left);
        }
        // 找到节点 情况2：节点没有左子树，若离它最近的、自左而来的祖先就是前任
        return ancestorFromLeft == null ?
                null : ancestorFromLeft.value;
    }

    /**
     * <h3>根据关键字删除</h3>
     *
     * @param key 关键字
     * @return 被删除关键字对应值
     */
    public Object delete(int key) {
        List<Object> result = new ArrayList<>(); // 保存被删除节点的值
        root = doDelete(root, key, result);
        return result.isEmpty() ? null : result.get(0);
    }

    /*
              4
             / \
            2   6
           /     \
          1       7

        node 起点
        返回值 删除后剩下的孩子(找到) 或 null(没找到) 类似于递归方式删除链表
     */
    private BSTNode doDelete(BSTNode node, int key, List<Object> result) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            // 重新建立节点之间的父子关系
            node.left = doDelete(node.left, key, result);
            return node;
        } else if (node.key < key) {
            node.right = doDelete(node.right, key, result);
            return node;
        }
        // 找到了待删除节点
        result.add(node.value);

        // 情况1-只有右孩子
        if (node.left == null) {
            return node.right;
        }
        // 情况2-只有左孩子
        if (node.right == null) {
            return node.left;
        }
        // 情况3-有两个孩子
        BSTNode s = node.right;
        while (s.left != null) {
            s = s.left;
        }
        // 在待删除节点右子树中删除后继节点
        s.right = doDelete(node.right, s.key, new ArrayList<>());

        // 找到待删除节点的后继节点
        s.left = node.left;
        return s;
    }

    /**
     * 非递归
     * @author zpstart
     * @return java.lang.Object
     */
    public Object delete0(int key) {
        BSTNode p = root;
        BSTNode parent = null;
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (key > p.key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        if (p.left == null) {
            // 情况1
            shift(parent, p, p.right);
        } else if (p.right == null) {
            // 情况2
            shift(parent, p, p.left);
        } else {
            // 情况4
            // 4.1 被删除节点寻找后继节点
            BSTNode s = p.right;
            BSTNode sParent = p;
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // 后继节点即为s
            // 4.2 处理后继节点的后事
            if (sParent != p) { // 后继节点与被删除节点不相邻
                shift(sParent, s, s.right);
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
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public List<Object> less(int key) {
        List<Object> result = new ArrayList<>();
        BSTNode curr = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key >= key) {
                    break;
                }
                result.add(pop.value);
                curr = pop.right;
            }
        }
        return result;
    }

    public List<Object> greater(int key) { // 反向中序遍历 Reverse in-order
        List<Object> result = new ArrayList<>();
        BSTNode curr = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.right;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key <= key) {
                    break;
                }
                result.add(pop.value);
                curr = pop.left;
            }
        }
        return result;
    }

    public List<Object> between(int key1, int key2) {
        List<Object> result = new ArrayList<>();
        BSTNode curr = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.value);
                }
                curr = pop.right;
            }
        }
        return result;
    }
}

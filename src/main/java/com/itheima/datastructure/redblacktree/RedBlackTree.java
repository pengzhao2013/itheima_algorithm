package com.itheima.datastructure.redblacktree;


/**
 * 叶子节点没有自己兄弟的时候要考虑null值 经验：叶子节点是红色 可以没有兄弟节点 黑色叶子节点得成对出现
 *
 * @author zpstart
 * @create 2025-05-10 13:13
 */
public class RedBlackTree {
    enum Color {
        RED, BLACK;
    }

    Node root;

    private static class Node {
        int key;
        Object value;
        Node left;
        Node right;
        Node parent; // 父节点
        Color color = Color.RED;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Color color) {
            this.key = key;
            this.color = color;
        }

        public Node(int key, Color color, Node left, Node right) {
            this.key = key;
            this.color = color;
            this.left = left;
            this.right = right;
            if (left != null) {
                left.parent = this;
            }
            if (right != null) {
                right.parent = this;
            }
        }

        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        // 找叔叔节点
        Node uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }
            if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        Node sibling() {
            if (parent == null) {
                return null;
            }
            if (isLeftChild()) {
                return parent.right;
            } else {
                return parent.right;
            }
        }
    }

    // 判断红黑 处理null值
    boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    boolean isBlack(Node node) {
        return node == null || node.color == Color.BLACK;
    }

    // 右旋 1.parent的处理 2.旋转后新根的父子关系
    private void rightRotate(Node pink) {
        Node parent = pink.parent;

        Node yellow = pink.left;
        Node green = yellow.right;
        if (green != null) {
            green.parent = pink;
        }
        yellow.right = pink;
        yellow.parent = parent;
        pink.left = green;
        pink.parent = yellow;
        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    // 左旋
    private void leftRotate(Node pink) {
        Node parent = pink.parent;
        Node yellow = pink.right;
        Node green = yellow.left;
        if (green != null) {
            green.parent = pink;
        }
        yellow.left = pink;
        yellow.parent = parent;
        pink.right = green;
        pink.parent = yellow;
        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    /**
     * 新增或更新
     * <br>
     * 正常增、遇到红红不平衡进行调整
     *
     * @param key   键
     * @param value 值
     */
    public void put(int key, Object value) {
        // 找空位
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (key > p.key) {
                parent = p;
                p = p.right;
            } else {
                p.value = value;
                return;
            }
        }
        Node inserted = new Node(key, value);
        if (parent == null) {
            root = inserted;
        } else if (key < parent.key) {
            parent.left = inserted;
            inserted.parent = parent;
        } else {
            parent.right = inserted;
            inserted.parent = parent;
        }
        fixNeighborRed(inserted);
    }

    void fixNeighborRed(Node x) {
        // case 1 插入节点是根节点，变黑即可
        if (x == root) {
            x.color = Color.BLACK;
            return;
        }
        // case 2 插入节点父亲是黑色，无需调整
        if (isBlack(x.parent)) {
            return;
        }
        /* case 3 当红红相邻，叔叔为红时
            需要将父亲、叔叔变黑、祖父变红，然后对祖父做递归处理
        */
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandParent = parent.parent;
        if (isRed(uncle)) {
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandParent.color = Color.RED;
            fixNeighborRed(grandParent);
            return;
        }
        // case 4 当红红相邻，叔叔为黑时
        if (parent.isLeftChild() && x.isLeftChild()) { //LL
            // 父亲变黑，祖父变红 祖父右旋
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            rightRotate(grandParent);
        } else if (parent.isLeftChild()) {//LR
            leftRotate(parent); // 插入节点此时变成parent
            x.color = Color.BLACK; // 此时的父亲变黑 祖父变红
            grandParent.color = Color.RED;
            rightRotate(grandParent);
        } else if (!x.isLeftChild()) {// RR
            // 父亲变黑，祖父变红 祖父左旋
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            leftRotate(grandParent);
        } else { //RL
            rightRotate(parent);
            x.color = Color.BLACK;
            grandParent.color = Color.RED;
            leftRotate(grandParent);
        }
    }

    /**
     * 删除
     * <br>
     * 正常删、会用到李代桃僵技巧、遇到黑黑不平衡进行调整
     *
     * @param key 键
     */
    public void remove(int key) {
        Node deleted = find(key);
        if (deleted == null) {
            return;
        }
        doRemove(deleted);
    }

    /**
     * 双黑情况 删除和后继都是黑
     * @author zpstart
     * @return void
     */
    private void fixDoubleBlack(Node x) {
        if (x == root) {
            return;
        }
        Node parent = x.parent;
        Node sibling = x.sibling();
        // case3 兄弟节点是红色 -> 旋转
        if (isRed(sibling)) {
            if (x.isLeftChild()) {
                leftRotate(parent);
            } else {
                rightRotate(parent);
            }
            parent.color = Color.RED;
            sibling.color = Color.BLACK;
            fixDoubleBlack(x);
            return;
        }
        // case4 兄弟是黑色 并且两个侄子也是黑色
        if (sibling != null) {
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = Color.RED;
                if (isRed(parent)) {
                    parent.color = Color.BLACK;
                } else {
                    // 说明此条路径缺少一个黑色节点 再次父节点触发双黑
                    fixDoubleBlack(parent);
                }
            } else {
//                case5 兄弟是黑色 两个侄子有可能是红色或其中一个是红色
                // LL
                if (sibling.isLeftChild() && isRed(sibling.left)) {
                    rightRotate(parent);
                    // 旋转后原来的parent要变成黑 即被删除节点的颜色
                    // 侄子要变黑 兄弟节点要变成原来父亲节点的颜色
                    sibling.left.color = Color.BLACK;
                    sibling.color = parent.color;

                } else if (sibling.isLeftChild() && isRed(sibling.right)) {
                    // LR
                    sibling.right.color = parent.color;
                    leftRotate(sibling);
                    rightRotate(parent);
                }
                parent.color = Color.BLACK;
            }
        } else {
            fixDoubleBlack(parent);
        }
    }
    private void doRemove(Node deleted) {
        Node replaced = findReplaced(deleted);
        Node parent = deleted.parent;
        // 没有孩子
        if (replaced == null) {
            // case1 删除的是根节点
            if (deleted == root) {
                root = null;
            } else { // 删除的不是根节点且没有孩子
                if (isBlack(deleted)) {
                    // 复杂调整
                    fixDoubleBlack(deleted);
                } else {
                    // 红色叶子,无需任何调整
                }
                if (deleted.isLeftChild()) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                deleted.parent = null;
            }
            return;
        }
        // 有一个孩子情况
        if (deleted.left == null || deleted.right == null) {
            // case1 删除的是根节点
            if (deleted == root) {
                root.key = replaced.key;
                root.value = replaced.value;
                root.left = root.right = null;
            } else {
                if (deleted.isLeftChild()) {
                    parent.left = replaced;
                } else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.parent = deleted.left = deleted.right = null; // 有助于GC
                if (isBlack(deleted) && isBlack(replaced)) {// 被删和后继节点都是黑
                    // 复杂处理
                    fixDoubleBlack(replaced);
                } else {
                    // case2
                    replaced.color = Color.BLACK;
                }
            }
            return;
        }
        // case0 有两个孩子 李代桃僵 =>只有一个孩子的待删除节点或没有孩子的待删除节点
        int t = deleted.key;
        deleted.key = replaced.key;
        replaced.key = t;

        Object v = deleted.value;
        deleted.value = replaced.value;
        replaced.value = v;
        doRemove(replaced);

    }

    // 找到删除节点
    private Node find(int key) {
        Node p = root;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null; //没找到
    }

    // 查找剩余节点
    private Node findReplaced(Node deleted) {
        if (deleted.left == null && deleted.right == null) {
            return null;
        }
        if (deleted.left == null) {
            return deleted.right;
        }
        if (deleted.right == null) {
            return deleted.left;
        }
        Node s = deleted.right; // 找后继
        while (s.left != null) {
            s = s.left;
        }
        return s;
    }
}

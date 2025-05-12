package com.itheima.datastructure.binarysearchtree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TestBSTTree2_1 {

    public BSTTree2_1<String, String> createTree(){
        /*
                     4
                   /   \
                  2     6
                 / \   / \
                1   3 5   7
         */
        BSTTree2_1.BSTNode<String,String> n1 = new BSTTree2_1.BSTNode<>("a", "张无忌");
        BSTTree2_1.BSTNode<String,String> n3 = new BSTTree2_1.BSTNode<>("c", "宋青书");
        BSTTree2_1.BSTNode<String,String> n2 = new BSTTree2_1.BSTNode<>("b", "周芷若", n1, n3);

        BSTTree2_1.BSTNode<String,String> n5 = new BSTTree2_1.BSTNode<>("e","说不得");
        BSTTree2_1.BSTNode<String,String> n7 = new BSTTree2_1.BSTNode<>("g","殷离");
        BSTTree2_1.BSTNode<String,String> n6 = new BSTTree2_1.BSTNode<>("f", "赵敏", n5, n7);
        BSTTree2_1.BSTNode<String,String> root = new BSTTree2_1.BSTNode<>("d", "小昭", n2, n6);

        BSTTree2_1<String,String> tree = new BSTTree2_1<>();
        tree.root = root;
        return tree;
    }

    @Test
    void get() {
        BSTTree2_1<String,String> tree = createTree();
        assertEquals("张无忌", tree.get("a"));
        assertEquals("周芷若", tree.get("b"));
        assertEquals("宋青书", tree.get("c"));
        assertEquals("小昭", tree.get("d"));
        assertEquals("说不得", tree.get("e"));
        assertEquals("赵敏", tree.get("f"));
        assertEquals("殷离", tree.get("g"));
        assertNull(tree.get("h"));
    }
}
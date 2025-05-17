package com.itheima.algorithm.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zpstart
 * @create 2025-05-16 20:56
 */
public class HuffmanTree {
    /*
        Huffman 树的构建过程

        1. 将统计了出现频率的字符，放入优先级队列

        2. 每次出队两个频次最低的元素，给它俩找个爹
        3. 把爹重新放入队列，重复 2~3
        4. 当队列只剩一个元素时，Huffman 树构建完成
     */
    static class Node {
        Character ch;

        int freq;

        Node left;

        Node right;

        String code;

        public Node(Character ch) {
            this.ch = ch;
        }

        public Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public int freq() {
            return freq;
        }

        boolean isLeaf() {
            return left == null; // 满二叉树,有左孩子就会有右孩子
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", freq=" + freq +
                    '}';
        }
    }

    String str;

    Map<Character, Node> map = new HashMap<>();

    Node root;

    public HuffmanTree(String str) {
        this.str = str;
        // 功能1:统计频率
        char[] chars = str.toCharArray();
        for (char ch : chars) {
//            if (!map.containsKey(ch)) {
//                map.put(ch, new Node(ch));
//            }
//            Node node = map.get(ch);
//            node.freq++;
            Node node = map.computeIfAbsent(ch, Node::new);
            node.freq++;
        }
        // 功能2:构造树
        // 小顶堆
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::freq));
        queue.addAll(map.values());

        while (queue.size() >= 2) {
            Node x = queue.poll();
            Node y = queue.poll();
            int freq = x.freq + y.freq;
            queue.offer(new Node(freq, x, y));
        }
        root = queue.poll();
        // 功能3:计算每个字符的编码
        int sum = dfs(root, new StringBuilder()); // 深度优先遍历

        for (Node node : map.values()) {
            System.out.println(node + " " + node.code);
        }
        System.out.println("总共占用字节数:" + " " + sum);
    }

    private int dfs(Node node, StringBuilder code) {
        int sum = 0;
        if (node.isLeaf()) {
            // 找到编码
            node.code = code.toString();
            sum = node.freq * code.length();
        } else {
            sum += dfs(node.left, code.append("0"));
            sum += dfs(node.right, code.append("1"));
        }
        if (code.length() > 0) {
            code.deleteCharAt(code.length() - 1);
        }
        return sum;
    }

    public String encode() {
        char[] charArray = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            stringBuilder.append(map.get(c).code);
        }
        return stringBuilder.toString();
    }

    public String decode(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Node node = root;
        while (i < chars.length) {
            if (!node.isLeaf()) { // 非叶子
                if (chars[i] == '0') {
                    node = node.left;
                } else if (chars[i] == '1') {
                    node = node.right;
                }
                i++;
            }
            if (node.isLeaf()) {
                sb.append(node.ch);
                node = root;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree("abbccccccc");
        String encoded = tree.encode();
        System.out.println(encoded);
        System.out.println(tree.decode(encoded));
    }

}

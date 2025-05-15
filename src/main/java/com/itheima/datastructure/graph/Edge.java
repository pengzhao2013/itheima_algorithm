package com.itheima.datastructure.graph;

/**
 * 边
 * @Author : zpstart
 * @Date: 2025-05-15 11:10
 */
public class Edge {
    Vertex linked; // 终点

    int weight;

    public Edge(Vertex linked) {
        this(linked, 1);
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }
}

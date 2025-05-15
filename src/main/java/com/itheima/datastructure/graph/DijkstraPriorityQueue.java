package com.itheima.datastructure.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author : zpstart
 * @Date: 2025-05-15 16:25
 */
public class DijkstraPriorityQueue {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(new Edge(v3, 9), new Edge(v2, 7), new Edge(v6, 14));
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(new Edge(v4, 11), new Edge(v6, 2));
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9));

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);

//        Vertex v1 = new Vertex("v1");
//        Vertex v2 = new Vertex("v2");
//        Vertex v3 = new Vertex("v3");
//        Vertex v4 = new Vertex("v4");
//
//        v1.edges = List.of(new Edge(v2, 2), new Edge(v3, 1));
//        v2.edges = List.of(new Edge(v3, -2));
//        v3.edges = List.of(new Edge(v4, 1));
//        v4.edges = List.of();
//
//        List<Vertex> graph = List.of(v1, v2, v3, v4);

        dijkstra(graph, v1);
    }

    private static void dijkstra(List<Vertex> graph, Vertex source) {
        // 默认是小顶堆
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(
                v -> v.dist));
        for (Vertex vertex : graph) {
            priorityQueue.offer(vertex);
        }
        source.dist = 0;
        while (!priorityQueue.isEmpty()) {
            // 3. 选取当前顶点
            Vertex curr = priorityQueue.peek();
            // 4. 更新当前顶点邻居距离
            if (!curr.visited) { // 防止重复加入的顶点再次执行操作
                updateNeighboursDist(curr, priorityQueue);
                curr.visited = true;
            }
            // 5. 移除当前顶点
            priorityQueue.poll();
        }

        for (Vertex v : graph) {
            System.out.println(v);
        }
    }

    private static void updateNeighboursDist(Vertex curr, PriorityQueue<Vertex> priorityQueue) {
        for (Edge edge : curr.edges) {
            Vertex n = edge.linked;
            if (!n.visited) { // 如果不contains说明移除之前的路径是最短的
                int dist = curr.dist + edge.weight;
                if (dist < n.dist) {
                    n.prev = curr;
                    n.dist = dist;
                    priorityQueue.offer(n);
                }
            }
        }
    }
}

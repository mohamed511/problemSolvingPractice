package com.ant.problemSolvingPractice.algoExpert.Study;


import com.ant.datastrucutreandalog.metwally.Algorithm.GraphDepthFirstSearch;

import java.util.*;

public class Revision {
    public static void main(String[] args) {
        List<String> nodes = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I");
        Graph g = new Graph(nodes);

        g.addEdges(0, List.of(1, 2));
        g.addEdges(1, List.of(0, 3, 4));
        g.addEdges(2, List.of(0, 3, 5));
        g.addEdges(3, List.of(1, 2, 4));
        g.addEdges(4, List.of(1, 5));
        g.addEdges(5, List.of(2, 3, 4, 7));
        g.addEdges(6, List.of(7, 8));
        g.addEdges(7, List.of(5, 6, 8));
        g.addEdges(8, List.of(6, 7));

        System.out.println("DFS traversal:");
        g.dfs();
    }

//    A -> B
//    B -> D
//    D -> C
//    C -> F
//    F -> E
//    F -> H
//    H -> G
//    G -> I
    static class Graph {
        Vertex[] vertices;
        int lastIndex = 0;

        public Graph(List<String> nodes) {
            vertices = new Vertex[nodes.size()];
            for (String d : nodes) {
                Vertex v = new Vertex(d, false);
                vertices[lastIndex] = v;
                lastIndex++;
            }
        }

        void addEdges(int vertexIndex, List<Integer> targetsIndex) {
            Vertex target = this.vertices[vertexIndex];
            target.edges = new Edge[targetsIndex.size()];
            for (int i = 0; i < targetsIndex.size(); i++) {
                Edge edge = new Edge(target, this.vertices[targetsIndex.get(i)]);
                target.edges[i] = edge;
            }
        }

        void dfs() {
            dfs(this.vertices[0]);
        }

        void dfs(Vertex current) {
            current.isVisited = true;
            Edge[] destination = current.edges;
            for (Edge e : destination) {
                if (!e.destination.isVisited) {
                    System.out.println(current.label + " -> " + e.destination.label);
                    dfs(e.destination);
                }
            }
        }
    }

    static class Vertex {
        String label;
        boolean isVisited;
        Edge[] edges;

        public Vertex(String label, boolean isVisited) {
            this.isVisited = isVisited;
            this.label = label;
        }
    }

    static class Edge {
        Vertex source;
        Vertex destination;
        double weight;

        public Edge(Vertex source, Vertex destination) {
            this.destination = destination;
            this.source = source;
        }

        public Edge(Vertex source, Vertex destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
}

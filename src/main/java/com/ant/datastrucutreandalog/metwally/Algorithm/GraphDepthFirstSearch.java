package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.List;


public class GraphDepthFirstSearch {
    public static void main(String[] args) {
        List<String> nodes = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I");
        GraphDepthFirstSearch.Graph g = new GraphDepthFirstSearch.Graph(nodes);

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


    static class Graph {
        public Vertex[] vertices;
        public int lastIndex = 0;

        public Graph(List<String> names) {
            vertices = new Vertex[names.size()];
            for (String name : names) {
                Vertex vertex = new Vertex(name, false);
                vertices[lastIndex] = vertex;
                lastIndex++;
            }
        }

        public void addEdges(int vertexIndex, List<Integer> targets) {
            this.vertices[vertexIndex].edges = new Edge[targets.size()];
            for (int i = 0; i < targets.size(); i++) {
                this.vertices[vertexIndex].edges[i] =
                        new Edge(this.vertices[vertexIndex], this.vertices[targets.get(i)]);
            }
        }

        public void dfs() {
            System.out.println("Depth First Search traversal:");
            dfsRecursion(vertices[0]);
            resetVisited();
        }

        private void dfsRecursion(Vertex current) {
            current.visited = true;
            Edge[] destination = current.edges;
            for (Edge v : destination) {
                if (!v.target.visited) {
                    System.out.println(current.label + " -> " + v.target.label);
                    dfsRecursion(v.target);
                }
            }

        }

        public void resetVisited() {
            for (Vertex vertex : vertices) {
                vertex.visited = false;
            }
        }
    }

    private static class Vertex {
        public String label;
        public boolean visited;
        public Edge[] edges;

        public Vertex(String label, boolean visited) {
            this.label = label;
            this.visited = visited;
        }
    }

    private static class Edge {
        public Vertex source;
        public Vertex target;
        public double weight;

        public Edge(Vertex source, Vertex target) {
            this.source = source;
            this.target = target;
            this.weight = 1.0; // Default weight
        }

        public Edge(Vertex source, Vertex target, double weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

}

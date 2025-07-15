package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.*;

public class GraphBreadthFirstSearch {
    public static void main(String[] args) {

        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('E', 'D', 'A'));
        graph.put('C', Arrays.asList('D', 'F', 'A'));
        graph.put('D', Arrays.asList('E', 'F', 'B'));
        graph.put('E', Arrays.asList('F', 'B'));
        graph.put('F', Arrays.asList('D', 'E', 'C', 'H'));
        graph.put('G', Arrays.asList('H', 'I'));
        graph.put('H', Arrays.asList('G', 'I', 'F'));
        graph.put('I', Arrays.asList('G', 'H'));
        breadthFirstSearch(graph);


        List<String> nodes = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I");
        Graph g = new Graph(nodes);

        g.addEdges(0, List.of(1, 2));
        g.addEdges(1, List.of(0, 3, 4));
        g.addEdges(2, List.of(0,3,5));
        g.addEdges(3, List.of(1,2,4));
        g.addEdges(4, List.of(1,5));
        g.addEdges(5, List.of(2,3,4,7));
        g.addEdges(6, List.of(7,8));
        g.addEdges(7, List.of(5,6,8));
        g.addEdges(8, List.of(6,7));

        System.out.println("BFS traversal:");
        g.bfs();


    }

    // first solution
    //    A -> B
    //    A -> C
    //    B -> E
    //    B -> D
    //    C -> F
    //    F -> H
    //    H -> G
    //    H -> I
    public static void breadthFirstSearch(Map<Character, List<Character>> graph) {
        Character anyKey = graph.keySet().iterator().next();
        Queue<Character> queue = new LinkedList<>();
        queue.add(anyKey);
        Map<Character, Boolean> visited = new HashMap<>();
        visited.put(anyKey, true);

        Character current;
        List<Character> destination;
        while (!queue.isEmpty()) {
            current = queue.poll();
            destination = graph.get(current);
            for (Character character : destination) {
                if (!visited.containsKey(character)) {
                    queue.add(character);
                    visited.put(character, true);
                    System.out.println(current + " ->  " + character);
                }
            }
        }
    }

    /**
     * second solution
     */

    private static class Graph {
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

        public void bfs() {
            Queue<Vertex> queue = new LinkedList<>();
            queue.add(vertices[0]);
            vertices[0].visited = true;
            while (!queue.isEmpty()) {
                Vertex current = queue.poll();
                Edge[] destination = current.edges;
                for (Edge edge : destination) {
                    if (!edge.target.visited) {
                        queue.add(edge.target);
                        edge.target.visited = true;
                        System.out.println(current.label + " -> " + edge.target.label);
                    }
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

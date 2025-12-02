package com.ant.datastrucutreandalog.metwally.Algorithm;

public class GraphDijkstrasShortestPath {
    public static void main(String[] args) {


        Graph g = new Graph(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"});

        g.addEdges(0, new Integer[]{1, 2, 3}, new Double[]{2.0, 4.0, 3.0});
        g.addEdges(1, new Integer[]{4, 5, 6}, new Double[]{7.0, 4.0, 6.0});
        g.addEdges(2, new Integer[]{4, 5, 6}, new Double[]{3.0, 2.0, 4.0});
        g.addEdges(3, new Integer[]{4, 5, 6}, new Double[]{4.0, 1.0, 5.0});
        g.addEdges(4, new Integer[]{7, 8}, new Double[]{1.0, 4.0});
        g.addEdges(5, new Integer[]{7, 8}, new Double[]{6.0, 3.0});
        g.addEdges(6, new Integer[]{7, 8}, new Double[]{3.0, 3.0});
        g.addEdges(7, new Integer[]{9}, new Double[]{3.0});
        g.addEdges(8, new Integer[]{9}, new Double[]{4.0});


        System.out.println("Graph Dijkstra's Shortest Path:");
        g.dijkstrasShortestPath();
    }

    static class Graph {
        public Vertex[] vertices;
        public int lastIndex = 0;

        public Graph(String[] names) {
            vertices = new Vertex[names.length];
            for (String name : names) {
                Vertex vertex = new Vertex(name, false);
                vertices[lastIndex] = vertex;
                lastIndex++;
            }
        }

        public void addEdges(int vertexIndex, Integer[] targets, Double[] weights) {
            this.vertices[vertexIndex].edges = new Edge[targets.length];
            for (int i = 0; i < targets.length; i++) {
                this.vertices[vertexIndex].edges[i] =
                        new Edge(this.vertices[vertexIndex], this.vertices[targets[i]], weights[i]);
            }
        }

        // output should be
        // A -> C -> E -> H -> J
        // 11.0
        public void dijkstrasShortestPath() {
            System.out.println("dijkstra's Shortest Path:");
            for (int i = 1; i < vertices.length; i++) {
                this.vertices[i].totalLength = Double.MAX_VALUE;
            }

            Vertex currentVertex;
            for (int i = 0; i < this.vertices.length; i++) {
                currentVertex = this.vertices[i];
                Edge[] destination = currentVertex.edges;
                if (destination == null) {
                    continue;
                }
                Edge currentEdge;
                for (int j = 0; j < destination.length; j++) {
                    currentEdge = destination[j];
                    double newLength = currentVertex.totalLength + currentEdge.weight;
                    if (newLength < currentEdge.target.totalLength) {
                        currentEdge.target.totalLength = newLength;
                        currentEdge.target.sourceOfTotalLength = currentVertex;
                    }
                }
            }


            StringBuilder fullPath = new StringBuilder(this.vertices[this.vertices.length - 1].label);

            Vertex lastOne = this.vertices[this.vertices.length - 1];
            while (lastOne.sourceOfTotalLength != null) {
//                fullPath.append(lastOne.soueceOfTotalLength.label).append(" -> ");
                fullPath.insert(0, lastOne.sourceOfTotalLength.label + " -> ");
                lastOne = lastOne.sourceOfTotalLength;
            }


            System.out.println(fullPath);
            System.out.println(this.vertices[this.vertices.length-1].totalLength);
        }


        public void resetVisited() {
            for (Vertex vertex : vertices) {
                vertex.visited = false;
                vertex.totalLength = 0;
                vertex.sourceOfTotalLength = null;
            }
        }
    }

    private static class Vertex {
        public String label;
        public boolean visited;
        public double totalLength;
        public Vertex sourceOfTotalLength;
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

        public Edge(Vertex source, Vertex target, double weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }


}

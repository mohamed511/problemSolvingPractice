package com.ant.datastrucutreandalog.metwally.Algorithm;

public class GraphPrimMinimumSpanningTree {
    public static void main(String[] args) {
        char[] labels = {'1', '2', '3', '4', '5', '6'};
        double[][] graph = {
                {0, 6.7, 5.2, 2.8, 5.6, 3.6},
                {6.7, 0, 5.7, 7.3, 5.1, 3.2},
                {5.2, 5.7, 0, 3.4, 8.5, 4.0},
                {2.8, 7.3, 3.4, 0, 8, 4.4},
                {5.6, 5.1, 8.5, 8, 0, 4.6},
                {3.6, 3.2, 4, 4.4, 4.6, 0}
        };
        System.out.println("Minimum Spanning Tree using Prim's Algorithm:");
        primMinimumSpanningTree(graph, labels);

        System.out.println("====================:");
        primMinimumSpanningTree_study(graph, labels);
    }

    private static void primMinimumSpanningTree(double[][] graph, char[] labels) {
        int graphLength = graph.length;
        int selectedEdgesCount = 0;

        boolean[] selected = new boolean[graphLength];
        selected[0] = true;

        while (selectedEdgesCount < graphLength - 1) {
            double tempMin = Double.MAX_VALUE;
            int tempFrom = -1;
            int tempTo = -1;
            for (int i = 0; i < graphLength; i++) {
                if (selected[i]) {
                    for (int j = 0; j < graphLength; j++) {
                        if (!selected[j] && graph[i][j] > 0 && graph[i][j] < tempMin) {
                            tempMin = graph[i][j];
                            tempFrom = i;
                            tempTo = j;
                        }
                    }
                }
            }
            selected[tempTo] = true;
            selectedEdgesCount++;
            System.out.printf("Edge %d: %c - %c (Weight: %.2f)%n", selectedEdgesCount, labels[tempFrom], labels[tempTo], tempMin);
        }
    }

    private static void primMinimumSpanningTree_study(double[][] graph, char[] labels) {
    }
}

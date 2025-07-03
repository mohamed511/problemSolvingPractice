package com.ant.study;

import java.util.*;

public class Revesion {
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
        primMinimumSpanningTree_study(graph, labels);
    }

    private static void primMinimumSpanningTree_study(double[][] graph, char[] labels) {
        int v = graph.length;
        int selectedEdgesCount = 0;
        boolean selectedNodes[] = new boolean[v];
        selectedNodes[0] = true;
        while (selectedEdgesCount < v - 1) {
            double min = Double.MAX_VALUE;
            int from = -1;
            int to = -1;
            for (int i = 0; i < v; i++) {
                if (selectedNodes[i]) {
                    for (int j = 0; j < v; j++) {
                        if (!selectedNodes[j] && graph[i][j] > 0 && graph[i][j] < min) {
                            min = graph[i][j];
                            from = i;
                            to = j;
                        }
                    }
                }
            }
            selectedEdgesCount++;
            selectedNodes[to] = true;
            System.out.println("Edge " + selectedEdgesCount + ": " + labels[from] + " - " + labels[to] + " (Weight: " + min + ")");
        }

    }
}

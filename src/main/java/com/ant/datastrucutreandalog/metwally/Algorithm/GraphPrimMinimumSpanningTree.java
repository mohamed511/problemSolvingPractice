package com.ant.datastrucutreandalog.metwally.Algorithm;


/**
 * ===> result
 * Edge 1: 1 - 4 (Weight: 2.80)
 * Edge 2: 4 - 3 (Weight: 3.40)
 * Edge 3: 1 - 6 (Weight: 3.60)
 * Edge 4: 6 - 2 (Weight: 3.20)
 * Edge 5: 6 - 5 (Weight: 4.60)

 * */
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
        int v = graph.length;
        int edgesCount = 0;
        boolean selected[] = new boolean[v];
        selected[0] = true;
        while (edgesCount < v - 1){
            double tempMin = Double.MAX_VALUE;
            int tempFrom = -1;
            int tempTo = -1;
            for (int i = 0; i < v; i++) {
                if (selected[i]){
                    for (int j = 0; j < v; j++) {
                        if (graph[i][j]>0&&!selected[j]&&graph[i][j]<tempMin){
                            tempMin = graph[i][j];
                            tempFrom = i;
                            tempTo = j;
                        }
                    }
                }

            }
            selected[tempTo] = true;
            edgesCount++;
            System.out.printf("Edge %d: %c - %c (Weight: %.2f)%n", edgesCount, labels[tempFrom], labels[tempTo], tempMin);
        }
    }
}

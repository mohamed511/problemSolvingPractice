package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.*;

public class DynamicProgrammingStagecoachProblem {
    public static void main(String[] args) {
        String[] labels = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int[][] data = {
                {0, 2, 4, 3, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 7, 4, 6, 0, 0, 0},
                {0, 0, 0, 0, 3, 2, 4, 0, 0, 0},
                {0, 0, 0, 0, 4, 1, 5, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        stagecoachProblem(labels, data);
    }

    private static void stagecoachProblem(String[] labels, int[][] data) {
        int length = data.length;
        State[] states = new State[length];
        // dummy value to avoid null pointer exception in first add item
        states[length - 1] = new State("", "", 0);

        for (int i = length - 2; i >= 0; i--) {
            states[i] = new State(labels[i], labels[i], Integer.MAX_VALUE);
            for (int j = i + 1; j < length; j++) {
                if (data[i][j] == 0) {
                    continue;
                }
                int newCost = data[i][j] + states[j].cost;
                if (newCost < states[i].cost) {
                    states[i].to = labels[j];
                    states[i].cost = newCost;
                }
            }
        }

        System.out.println(Arrays.toString(states));
        int i = 0;
        int j = 0;
        String[] path = new String[length];
        path[0] = "A";
        while (i < states.length) {
            if (states[i].from.equalsIgnoreCase(path[j])) {
                path[j + 1] = states[i].to;
                j++;
            }
            i++;
        }
        System.out.println(states[0].cost);
        System.out.println(Arrays.toString(path));
    }


}

class State {
    String from;
    String to;
    Integer cost;

    public State(String from, String to, Integer cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{" + "from='" + from + '\'' +
                ",to='" + to + '\'' +
                ",cost=" + cost +
                '}'+"\n";
    }
}
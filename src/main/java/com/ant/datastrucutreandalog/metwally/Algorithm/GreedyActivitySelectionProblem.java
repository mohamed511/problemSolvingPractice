package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class GreedyActivitySelectionProblem {
    public static void main(String[] args) {
        int[] start = {9, 10, 11, 12, 13, 15};
        int[] end = {11, 11, 12, 14, 15, 16};
        activitySelectionProblem(start, end);
    }

    private static void activitySelectionProblem(int[] start, int[] end) {
        List<Integer> result = new ArrayList<>();
        result.add(start[0]);
        int j = 0;
        for (int i = 1; i < start.length; i++) {
            if (start[i] >= end[j]) {
                result.add(start[i]);
                j = i;
            }
        }
        System.out.println(result);
    }
}

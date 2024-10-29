package com.ant.problemSolvingPractice.algoExpert.greedy;

import java.util.Arrays;

public class MinimumWaitingTime {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 6};
        System.out.println(minimumWaitingTime(arr));
    }

    public static int minimumWaitingTime(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);
        int total = 0;
        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int remainQueries = queries.length - (i + 1);
            total += duration * remainQueries;
        }
        return total;
    }
}

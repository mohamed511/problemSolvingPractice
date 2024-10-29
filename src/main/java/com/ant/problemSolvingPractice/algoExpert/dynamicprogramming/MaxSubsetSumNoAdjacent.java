package com.ant.problemSolvingPractice.algoExpert.dynamicprogramming;

public class MaxSubsetSumNoAdjacent {
    public static void main(String[] args) {
        int[] array1 = {75, 105, 120, 75, 90, 135};
        int[] array = {7, 10, 12, 7, 9, 14};
        System.out.println(maxSubsetSumNoAdjacent(array));
        System.out.println(maxSubsetSumNoAdjacentOptmized(array));
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int[] maxSum = array.clone();
        maxSum[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + array[i]);
        }
        return maxSum[maxSum.length - 1];
    }

    public static int maxSubsetSumNoAdjacentOptmized(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int second = array[0];
        int first = Math.max(array[0], array[1]);
        int current = 0;
        for (int i = 2; i < array.length; i++) {
            current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }
        return current;
    }
}

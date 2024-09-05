package com.ant.problemSolvingPractice.algoExpert.array.sortedSquaredArray;

import java.util.Arrays;

public class SortedSquaredArray {
    public static void main(String[] args) {
        int[] arr = {-1, -1, 2, 3, 3, 3, 4};
        int[] result = sortedSquaredArray(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];
        int start = 0;
        int end = array.length - 1;
        int i = array.length - 1;

        while (start <= end) {
            if (Math.abs(array[start]) > Math.abs(array[end])) {
                result[i] = (int) Math.pow(array[start], 2);
                start++;
            } else {
                result[i] = (int) Math.pow(array[end], 2);
                end--;
            }
            i--;
        }
        return result;
    }

    public static int[] sortedSquaredArray2(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = (int) Math.pow(array[i], 2);
        }
        Arrays.sort(result);
        return result;
    }

}

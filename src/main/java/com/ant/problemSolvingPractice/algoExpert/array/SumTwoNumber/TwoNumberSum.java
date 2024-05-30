package com.ant.problemSolvingPractice.algoExpert.array.SumTwoNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class TwoNumberSum {

    // o(n^2) | o(1) space
    public static int[] solution1(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int y = i + 1; y < array.length; y++) {
                if (array[i] + array[y] == targetSum) {
                    return new int[]{array[i], array[y]};
                }
            }
        }
        return new int[]{};
    }

    // o(n) time | o(n) space
    public static int[] solution2(int[] array, int targetSum) {
        HashMap<Integer, Boolean> table = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer x = targetSum - array[i];
            if (table.get(x) != null) {
                return new int[]{x, array[i]};
            } else {
                table.put(array[i], true);
            }
        }
        return new int[]{};
    }

    // o(n log n) time | o(1) space
    public static int[] solution3(int[] array, int targetSum) {
        Arrays.sort(array);
        int rightElement = 0;
        int leftElement = array.length - 1;
        while (rightElement < leftElement) {
            int result = array[rightElement] + array[leftElement];
            if (result == targetSum) {
                return new int[]{array[rightElement], array[leftElement]};
            } else if (result < targetSum) {
                rightElement++;
            } else if (result > targetSum) {
                leftElement--;
            }
        }
        return new int[]{};
    }
}
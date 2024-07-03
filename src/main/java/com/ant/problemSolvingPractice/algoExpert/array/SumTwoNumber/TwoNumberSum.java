package com.ant.problemSolvingPractice.algoExpert.array.SumTwoNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        System.out.println(Arrays.toString(solution1(arr, targetSum)));
        System.out.println(Arrays.toString(solution2(arr, targetSum)));
        System.out.println(Arrays.toString(solution3(arr, targetSum)));

    }

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
        Set<Integer> table = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            Integer x = targetSum - array[i];
            if (table.contains(x)) {
                return new int[]{x, array[i]};
            } else {
                table.add(array[i]);
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
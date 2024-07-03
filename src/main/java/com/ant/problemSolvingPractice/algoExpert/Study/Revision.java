package com.ant.problemSolvingPractice.algoExpert.Study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Revision {
    public static void main(String[] args) {
        var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = Arrays.asList(1, 6, -1, 10);
        System.out.println(solution1(array, sequence));
        System.out.println(solution2(array, sequence));
        System.out.println(solution3(array, sequence));
        var array1 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence1 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        System.out.println(solution1(array1, sequence1));
        System.out.println(solution2(array1, sequence1));
        System.out.println(solution3(array1, sequence1));
        var array2 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence2 = Arrays.asList(1, 6, -1, 5);
        System.out.println(solution1(array2, sequence2));
        System.out.println(solution2(array2, sequence2));
        System.out.println(solution3(array2, sequence2));
    }

    public static boolean solution1(List<Integer> array, List<Integer> sequence) {
        int arrIndex = 0;
        int seqIndex = 0;
        while (seqIndex < sequence.size() && arrIndex < array.size()) {
            if (sequence.get(seqIndex).equals(array.get(arrIndex))) {
                seqIndex++;
            }
            arrIndex++;
        }
        return sequence.size() == seqIndex;
    }

    public static boolean solution2(List<Integer> array, List<Integer> sequence) {
        int seqIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            if (seqIndex == sequence.size()) {
                break;
            }
            if (sequence.get(seqIndex).equals(array.get(i))) {
                seqIndex++;
            }
        }
        return seqIndex == sequence.size();
    }

    public static boolean solution3(List<Integer> array, List<Integer> sequence) {
        if (sequence.isEmpty()) {
            return true;
        }
        if (array.contains(sequence.get(0))) {
            return solution3(array.subList(array.indexOf(sequence.get(0)) + 1, array.size()), sequence.subList(1, sequence.size()));
        }
        return false;
    }
}

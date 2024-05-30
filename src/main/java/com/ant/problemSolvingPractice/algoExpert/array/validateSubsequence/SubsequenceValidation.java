package com.ant.problemSolvingPractice.algoExpert.array.validateSubsequence;

import java.util.List;
import java.util.Objects;

public class SubsequenceValidation {
    // o(n) time | o(1) space - where n is the length of the array
    public static boolean solution1(List<Integer> array, List<Integer> sequence) {
        int arrIndex = 0;
        int sequenceIndex = 0;
        while (arrIndex < array.size() && sequenceIndex < sequence.size()) {
            if (array.get(arrIndex).equals(sequence.get(sequenceIndex))) {
                sequenceIndex++;
            }
            arrIndex++;
        }
        return sequenceIndex == sequence.size();
    }

    // o(n) time | o(1) space - where n is the length of the array
    public static boolean solution2(List<Integer> array, List<Integer> sequence) {
        int sequenceIndex = 0;
        for (int arrIndex = 0; arrIndex < array.size(); arrIndex++) {
            if (sequenceIndex == sequence.size()) {
                break;
            }
            if (array.get(arrIndex).equals(sequence.get(sequenceIndex))) {
                sequenceIndex++;
            }
        }
        return sequenceIndex == sequence.size();
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

    public static boolean solution4(List<Integer> array, List<Integer> sequence) {
        Integer sequencePointer = 0;
        for (Integer x : array) {
            if (Objects.equals(x, sequence.get(sequencePointer))) {
                sequencePointer++;
            }
            if (sequencePointer.equals(sequence.size())) {
                return true;
            }
        }
        return false;
    }
}

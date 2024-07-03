package com.ant.problemSolvingPractice.algoExpert.FamousAlgo.KadaneAlgo;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] array = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(array));
    }

    /**
     * O(n) time | O(1) space
     * max ending here= max(maxEndingHere+currentIndex , currentIndex);
     * axSoFar = max(maxEndingHere , maxSoFar);
     */
    public static int kadanesAlgorithm(int[] array) {
        int maxOfSubArray = array[0];
        int theMaximumNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            maxOfSubArray = Math.max(maxOfSubArray + array[i], array[i]);
            theMaximumNumber = Math.max(theMaximumNumber, maxOfSubArray);
        }
        return theMaximumNumber;
    }
}

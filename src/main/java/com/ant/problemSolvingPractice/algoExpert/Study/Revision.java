package com.ant.problemSolvingPractice.algoExpert.Study;

import java.util.*;

public class Revision {
    public static void main(String[] args) {
        int[] num = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maximumSubarraySum(num, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> elementsCount = new HashMap<>();
        // get first 3 elements
        for (int i = 0; i < k; i++) {
            elementsCount.put(nums[i], elementsCount.getOrDefault(nums[i], 0) + 1);
            currentSum += nums[i];
        }

        if (elementsCount.size() == k) {
            maxSum = currentSum;
        }

        for (int i = k; i < nums.length; i++) {
            // remove element
            int removeElement = nums[i - k];
            currentSum -= removeElement;
            elementsCount.put(removeElement, elementsCount.get(removeElement) - 1);
            if (elementsCount.get(removeElement) == 0) {
                elementsCount.remove(removeElement);
            }
            int addElement = nums[i];
            currentSum += addElement;
            elementsCount.put(addElement, elementsCount.getOrDefault(addElement, 0) + 1);

            if (elementsCount.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}

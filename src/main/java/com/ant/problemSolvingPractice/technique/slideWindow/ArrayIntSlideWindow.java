package com.ant.problemSolvingPractice.technique.slideWindow;

import java.util.*;

public class ArrayIntSlideWindow {
    public static void main(String[] args) {
        int[] num = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maximumSubArraySumOptimized(num, k));
    }

    public static long maximumSubArraySum(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> distinctNumbers = new HashSet<>();
            int[] sub = new int[k];
            int currentSum = 0;
            for (int j = 0; j < k; j++) {
                sub[j] = nums[i + j];
                distinctNumbers.add(sub[j]);
                currentSum += sub[j];
            }
            if (distinctNumbers.size() == sub.length) {
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }
            System.out.println(Arrays.toString(sub) + " = " + (distinctNumbers.size() == sub.length));
        }
        System.out.println(maxSum);
        return maxSum;
    }

    public static long maximumSubArraySumOptimized(int[] nums, int k) {
        int maxSum = 0;
        int currentSum = 0;
        Map<Integer, Integer> elementCount = new HashMap<>();

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
            elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0) + 1);
        }

        // Check if the first window has all distinct elements
        if (elementCount.size() == k) {
            maxSum = currentSum;
        }

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            // Remove the element going out of the window
            int removedElement = nums[i - k];
            currentSum -= removedElement;
            elementCount.put(removedElement, elementCount.get(removedElement) - 1);
            if (elementCount.get(removedElement) == 0) {
                elementCount.remove(removedElement);
            }
            // Add the new element
            int addElement = nums[i];
            currentSum += addElement;
            elementCount.put(addElement, elementCount.getOrDefault(addElement, 0) + 1);

            // Check if the current window has all distinct elements
            if (elementCount.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}

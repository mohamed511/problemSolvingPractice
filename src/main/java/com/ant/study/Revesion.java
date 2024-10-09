package com.ant.study;

import java.util.*;

public class Revesion {
    public static void main(String[] args) {
        int[] num = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maximumSubArraySumOptimized(num, k));
    }

    public static long maximumSubArraySumOptimized(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> elementCount = new HashMap<>();
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
            elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0) + 1);
        }

        if (elementCount.size() == k) {
            maxSum = currentSum;
        }

        for (int i = k; i < nums.length; i++) {
            int removedElement = nums[i - k];
            currentSum -= removedElement;
            elementCount.put(removedElement, elementCount.get(removedElement) - 1);
            if (elementCount.get(removedElement) == 0) {
                elementCount.remove(removedElement);
            }
            // add new element
            int newItem = nums[i];
            currentSum += newItem;
            elementCount.put(newItem, elementCount.getOrDefault(newItem, 0) + 1);
            if (elementCount.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}

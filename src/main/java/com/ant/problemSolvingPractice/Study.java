package com.ant.problemSolvingPractice;

import java.util.HashSet;
import java.util.Set;

public class Study {
    public static void main(String[] args) {
        int[] num = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maximumSubArraySum(num, k));

        int[] num2 = {1, 2, 1, 1, 3};
        int k2 = 3;
        System.out.println(maximumSubArraySum(num2, k2));

        int[] num3 = {4,4,4};
        int k3 = 3;
        System.out.println(maximumSubArraySum(num3, k3));
    }

    public static long maximumSubArraySum(int[] nums, int k) {
        int arrLength = nums.length;
        Set<Integer> integerSet = new HashSet<>();

        if (arrLength < k) {
            return 0;
        }
        int sum = 0;
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
            integerSet.add(nums[i]);
        }
        if (sum < currentSum && integerSet.size() == k) {
            sum = currentSum;
        }

        for (int i = k; i < arrLength; i++) {
            int removeItem = nums[i - k];
            currentSum -= removeItem;
            integerSet.remove(removeItem);

            int addItem = nums[i];
            currentSum += addItem;
            integerSet.add(addItem);
            if (sum < currentSum && integerSet.size() == k) {
                sum = currentSum;
            }
        }
        return sum;
    }
}

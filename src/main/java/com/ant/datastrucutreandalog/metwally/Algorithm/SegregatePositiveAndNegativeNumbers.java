package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SegregatePositiveAndNegativeNumbers {
    public static void main(String[] args) {
        int[] arr = {6, -5, 12, 10, -9, -1};// -5,-9,-1,6,12,10
        segregate(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr3 = {-8, 65, 9, 7, -3, -5, 54};// -8,-3,-5,65,9,7,54
        segregate(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));

        System.out.println("=" .repeat(100));
        // another way O(n)
        int[] arr2 = {6, -5, 12, 10, -9, -1};// -5,-9,-1,6,12,10
        segregate2(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr4 = {-8, 65, 9, 7, -3, -5, 54};// -8,-3,-5,65,9,7,54
        segregate2(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    /**
     * using merge sort
     * O(n log n)
     **/
    public static void segregate(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        segregate(arr, start, mid);
        segregate(arr, mid + 1, end);
        segregateMerge(arr, start, end, mid);
    }

    private static void segregateMerge(int[] arr, int start, int end, int mid) {
        // calculate length for left and right array
        int leftArrLength = (mid - start) + 1;
        int rightArrLength = end - mid;
        // create left and right array
        int[] leftArr = new int[leftArrLength];
        int[] rightArr = new int[rightArrLength];
        // add data to left and right array
        int indexLeft;
        int indexRight;

        for (indexLeft = 0; indexLeft < leftArr.length; indexLeft++) {
            leftArr[indexLeft] = arr[start + indexLeft];
        }

        for (indexRight = 0; indexRight < rightArr.length; indexRight++) {
            rightArr[indexRight] = arr[mid + 1 + indexRight];
        }
        // loop and add the negative numbers from left array first
        int indexMain = start;
        indexLeft = 0;
        indexRight = 0;

        while (indexLeft < leftArr.length) {
            if (leftArr[indexLeft] < 0) {
                arr[indexMain] = leftArr[indexLeft];
                indexMain++;
                indexLeft++;
            } else {
                break;
            }
        }
        // loop and add the negative numbers from right array
        while (indexRight < rightArr.length) {
            if (rightArr[indexRight] < 0) {
                arr[indexMain] = rightArr[indexRight];
                indexRight++;
                indexMain++;
            } else {
                break;
            }
        }

        // loop on the remain items in left
        // (will be negative) and add it to the main array
        for (; indexLeft < leftArr.length; indexLeft++) {
            arr[indexMain] = leftArr[indexLeft];
            indexMain++;
        }
        // loop on the remain items in right
        // (will be negative) and add it to the main array
        for (; indexRight < rightArr.length; indexRight++) {
            arr[indexMain] = rightArr[indexRight];
            indexMain++;
        }
    }

    /**
     * using another way
     * O(n)
     **/
    public static void segregate2(int[] arr) {
        List<Integer> negativeList = new ArrayList<>();
        List<Integer> postiveList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negativeList.add(arr[i]);
            } else {
                postiveList.add(arr[i]);
            }
        }

        List<Integer> combined = new ArrayList<>(negativeList);
        combined.addAll(postiveList);
        for (int i = 0; i < combined.size(); i++) {
            arr[i] = combined.get(i);
        }
    }
}

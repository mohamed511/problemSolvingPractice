package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.Arrays;

public class MyMergeSortImpl {
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {8, 65, 9, 7, 3, 5, 54};
        mergeSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
    }

    // O(n log n)
    // n => number of operations
    // log n => number of levels
    // every level have n of operations
    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i, j, k;

        int leftLength = mid - start + 1;
        int rightLength = end - mid;

        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[rightLength];

        // add data to the array
        for (i = 0; i < leftLength; i++) {
            leftArr[i] = arr[start + i];
        }

        for (j = 0; j < rightLength; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        i = 0;
        j = 0;
        k = start;

        // loop and merge the data
        while (i < leftLength && j < rightLength) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // copy the rest of data in left array
        while (i < leftLength) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

}

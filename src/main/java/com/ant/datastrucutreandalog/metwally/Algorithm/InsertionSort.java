package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4, 3};
        insertionSort(arr);
    }


    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // -> n
            int key = arr[i]; // -> 1
            int j;// -> 1
            for (j = i - 1; j >= 0; j--) { // -> n*n
                if (key < arr[j]) { // 1*n
                    arr[j + 1] = arr[j]; // 1*n
                } else {
                    break; // 1*n
                }
            }
            arr[j + 1] = key; // 1
        }
        System.out.println(Arrays.toString(arr));//1
    }
}

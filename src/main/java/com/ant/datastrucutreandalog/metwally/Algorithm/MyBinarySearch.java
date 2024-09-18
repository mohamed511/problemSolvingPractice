package com.ant.datastrucutreandalog.metwally.Algorithm;

public class MyBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearchImpl(arr, 1));//0
        System.out.println(binarySearchImpl(arr, 3));//2
        System.out.println(binarySearchImpl(arr, 4));//3
        System.out.println(binarySearchImpl(arr, 9));//8
        System.out.println(binarySearchImpl(arr, 0));//-1

    }

    // O(log n)
    public static Integer binarySearchImpl(int[] arr, int key) {
        int mid;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else if (key < arr[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }
}

package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class GreedySortedCharactersFrequencies {
    public static void main(String[] args) {
        String msg =
                "The output from Huffman's algorithm can be viewed as a variable length " +
                        "code table for encoding a source symbol. The algorithm derives this " +
                        "table from the estimated probability or frequency of occurrence for " +
                        "each possible value of the source symbol. as in other entropy encoding " +
                        "methods, more common symbols are generally represented using fewer bits " +
                        "than less common symbols. Huffman's method can be efficiently " +
                        "implemented, finding a code in time linear to the number of input " +
                        "weights if these weights are sorted. However, although optimal among " +
                        "methods encoding symbols separately, Huffman coding is not always " +
                        "optimal among all compression methods it is replaced with arithmetic " +
                        "coding or asymmetric numeral systems if better compression ratio is " +
                        "required.";
        //ASCIIMethod("HelloWorld");
        System.out.println("========");
        anyCodeMethod(msg);
    }

    /**
     * get any char ASCII 127 and the count of it and sort it
     *
     * @param message
     */
    public static void ASCIIMethod(String message) {
        int[] freq = new int[127];
        for (int i = 0; i < message.length(); i++) {
            int current = message.charAt(i);
            freq[current]++;
        }
        print(freq);
    }

    public static void print(int[] freq) {
        System.out.print("{");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                char c = (char) i;
                System.out.print(c + "=" + freq[i] + " - ");
            }
        }
        System.out.println("}");
        System.out.println();
    }

    /**
     * get any char UTF-8 and the count of it and sort it
     *
     * @param message
     */
    public static void anyCodeMethod(String message) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : message.toCharArray()) {
            result.merge(c, 1, Integer::sum);
        }
        System.out.println(result);
        sortHash(result);
    }

    /**
     * copy map to 2d array to be able to sort it
     *
     * @param result
     */
    public static void sortHash(Map<Character, Integer> result) {
        int[][] arr = new int[result.size()][2];
        int index = 0;
        for (Map.Entry<Character, Integer> c : result.entrySet()) {
            arr[index][0] = c.getKey();
            arr[index][1] = c.getValue();
            index++;
        }
        System.out.println("array not sorted");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((char) arr[i][0] + "," + arr[i][1]);
        }
        System.out.println("===> ");
        sortArray(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println((char) arr[i][0] + "," + arr[i][1]);
        }
    }

    /**
     * sort the 2d array using merge sort
     *
     * @param arr
     */
    public static void sortArray(int[][] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sortArray(arr, start, mid);
        sortArray(arr, mid + 1, end);
        merge(arr, start, end, mid);
    }

    public static void merge(int[][] arr, int start, int end, int mid) {
        int i, j, k;
        int leftLength = mid - start + 1;
        int rightLength = end - mid;
        int[][] leftArr = new int[leftLength][2];
        int[][] rightArr = new int[rightLength][2];

        // add values to leftArr
        for (i = 0; i < leftLength; i++) {
            leftArr[i][0] = arr[start + i][0];
            leftArr[i][1] = arr[start + i][1];
        }
        // add values to rightArr
        for (j = 0; j < rightLength; j++) {
            rightArr[j][0] = arr[mid + 1 + j][0];
            rightArr[j][1] = arr[mid + 1 + j][1];
        }
        i = 0;
        j = 0;
        k = start;
        // sort depend on Frequencies
        while (i < leftLength && j < rightLength) {
            if (leftArr[i][1] <= rightArr[j][1]) {
                arr[k][0] = leftArr[i][0];
                arr[k][1] = leftArr[i][1];
                i++;
            } else {
                arr[k][0] = rightArr[j][0];
                arr[k][1] = rightArr[j][1];
                j++;
            }
            k++;
        }

        // get the remain form left
        while (i < leftLength) {
            arr[k][0] = leftArr[i][0];
            arr[k][1] = leftArr[i][1];
            i++;
            k++;
        }

        // get the remain form right
        while (j < rightLength) {
            arr[k][0] = rightArr[j][0];
            arr[k][1] = rightArr[j][1];
            j++;
            k++;
        }
    }
}

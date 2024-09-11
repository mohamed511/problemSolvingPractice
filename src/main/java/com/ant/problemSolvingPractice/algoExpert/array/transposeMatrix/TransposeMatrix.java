package com.ant.problemSolvingPractice.algoExpert.array.transposeMatrix;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        //int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] input = new int[][]{{1, 2}, {4, 5}, {7, 8}};
//        int[][] output = transposeMatrix(input);
        int[][] output = transposeMatrix2(input);
        for (int raw = 0; raw < output.length; raw++) {
            for (int col = 0; col < output[raw].length; col++) {
                System.out.print("{"+output[raw][col]+"}" + " ");
            }
            System.out.println();
        }
    }

    // O(w*h) time | O(w*h) space
    // w is the width of the matrix and h is the height
    // loop depend on raw
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] output = new int[matrix[0].length][matrix.length];
        System.out.println("length = "+output.length+" "+matrix.length);
        System.out.println("length col = "+output[0].length+" "+matrix[0].length);
        for (int raw = 0; raw < matrix.length; raw++) {
            for (int col = 0; col < matrix[raw].length; col++) {
                System.out.print("{"+matrix[raw][col]+"}" + " ");
                output[col][raw] = matrix[raw][col];
            }
            System.out.println();
        }
        return output;
    }

    // loop depend on column
    public static int[][] transposeMatrix2(int[][] matrix) {
        int[][] output = new int[matrix[0].length][matrix.length];
        for (int col = 0; col < matrix[0].length; col++) {
            for (int raw = 0; raw < matrix.length; raw++) {
                output[col][raw] = matrix[raw][col];
            }
        }
        return output;
    }
}

package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.Arrays;

public class DynamicProgrammingLongestCommonSubsequence2 {
    public static void main(String[] args) {
        String text1 = "HELLOWORLD";
        String text2 = "OHELOD";
        longestCommonSubsequence(text1, text2);

    }

    private static void longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] result = new int[length2 + 1][length1 + 1];
        for (int i = 1; i <= length2; i++) {
            for (int j = 1; j <= length1; j++) {
                int topCell = result[i - 1][j];
                int leftCell = result[i][j - 1];
                int topLeftCell = result[i - 1][j - 1];
                if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
                    result[i][j] = 1 + topLeftCell;
                } else {
                    result[i][j] = Math.max(topCell, leftCell);
                }
            }
        }
        print(result);
        System.out.println("result = " + result[length2][length1]);
        System.out.println(printCharLCS(text1, text2, result));
    }

    public static String printCharLCS(String text1, String text2, int[][] result) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = text2.length();
        int j = text1.length();

        while (i > 0 && j > 0) {
            // start from the bottom right
            int topCell = result[i - 1][j];
            int leftCell = result[i][j - 1];
            int current = result[i][j];
            // if current value > left value
            if (current > leftCell) {
                //the current value inherted from top
                // -- if current value == top value
                if (current == topCell) {
                    // move to top row
                    i--;
                } else {
                    // current value is origin of match
                    // add the char to the solution
                    stringBuilder.insert(0, text2.charAt(i - 1));
                    // -- -- move to the top row
                    // -- -- move to left column
                    i--;
                    j--;
                }
            } else {
                // move to left column
                j--;
            }
        }
        return stringBuilder.toString();
    }

    public static void print(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }

}

package com.ant.datastrucutreandalog.metwally.Algorithm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DynamicProgrammingLongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "HELLOWORLD";
        String text2 = "OHELOD";
        longestCommonSubsequence(text1, text2);
        System.out.println(lcsGPT(text1, text2));
    }

    private static void longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int result[][] = new int[len2 + 1][len1 + 1];
        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
                    result[i][j] = 1 + result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }

        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        System.out.println(result[len2][len1]);


        // start from the bottom right
        // if current value > left value
        // -- if current value == top value
        // -- -- //the current value inherited from top
        // -- -- move to top row
        // -- else
        // -- -- //current value is origin of match
        // -- -- add the char to the solution
        // -- -- move to the top row
        // -- -- move to left column
        // move to left column
        StringBuilder str = new StringBuilder();
        int i = len2;
        int j = len1;
        while (i > 0 && j > 0) {
            int currentCell = result[i][j];
            int leftCell = result[i - 1][j];
            int topCell = result[i - 1][j];
            int topLeftCell = result[i - 1][j - 1];
            if (currentCell > leftCell) {
                if (currentCell == topCell) {
                    //the current value inherited from top
                    i--;
//                    j--;
                } else {
                    //current value is origin of match
                    str.append(text2.charAt(i - 1));
                    i--;
                    j--;
                }
            } else {
                j--;
            }
        }
        System.out.println(str);
    }

    public static int lcsGPT(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a 2D table to store lengths of longest common subsequence
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp[][] in a bottom-up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, increase the length of subsequence
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If they don't match, take the maximum value from the previous subproblems
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The value at dp[m][n] contains the length of the LCS of str1 and str2
        return dp[m][n];
    }

}

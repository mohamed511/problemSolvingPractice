package com.ant.problemSolvingPractice.InterviewQuestion.RSA_2_2026;
/**
 * There are two wooden sticks of lengths A and B respectively. Each stick can be cut into multiple
 * shorter sticks of integer lengths. Your goal is to construct the largest possible square. To do this, you
 * must cut four sticks of the same length (note that there can be some leftover pieces). What is the
 * longest side of the square that you can achieve?
 *
 * Find and fix a bug in the given implementation of a function:
 *
 * class Solution { public int solution(int A, int B); }
 *
 * that, given two integers A and B, returns the side length of the largest square that you can obtain. If it
 * is not possible to create any square, the function should return 0.
 *
 * Examples:
 *
 * 1. Given A = 10, B = 21, the function should return 7. You can split the second stick into three sticks
 * of length 7 and shorten the first stick by 3.
 *
 * 2. Given A = 13, B = 11, the function should return 5. You can cut two sticks of length 5 from each of
 * the given sticks.
 *
 * The attached code is still incorrect for some inputs. Despite the error(s), the code may produce a
 * correct answer for the example test cases. The goal of the exercise is to find and fix the bug(s) in the
 * implementation. You can modify at most one line.
 *
 * Assume that:
 * • A and B are integers within the range [1..100,000].
 *
 * */
public class Rsa1 {

    static int countPieces(int length, int stick1, int stick2) {
        return (stick1 / length) + (stick2 / length);
    }

    static boolean canFormSquare(int length, int stick1, int stick2) {
        return countPieces(length, stick1, stick2) >= 4;
    }

    /**
     * find the issue with the code below and fix it
     * (A+b)/ 4  is correct
     */
    public static int solution(int A, int B) {
        for (int length = Math.min(A, B); length > 0; length--) {
            if (canFormSquare(length, A, B)) {
                return length;
            }
        }
        return 0;
    }
}

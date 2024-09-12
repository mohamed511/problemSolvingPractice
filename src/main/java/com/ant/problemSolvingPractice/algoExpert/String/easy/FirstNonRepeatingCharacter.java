package com.ant.problemSolvingPractice.algoExpert.String.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        //String str = "abcdcaf";
        String str = "faadabcbbebdf";

        System.out.println(firstNonRepeatingCharacter(str));
        System.out.println(firstNonRepeatingCharacter2(str));
    }

    // O(n) time | O(1)space - n is the length of the input
    // the constant space because the input string only has lowercase
    // so the hasTable will never have more than 26 char frequencies
    public static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> strFreq = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            strFreq.put(currentChar, strFreq.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (strFreq.get(currentChar) == 1) {
                return i;
            }
        }
        return -1;
    }

    // O(n^2) time | O(1)space - n is the length of the input
    public static int firstNonRepeatingCharacter2(String string) {
        for (int i = 0; i < string.length(); i++) {
            boolean hasDuplication = false;
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j) && j != i) {
                    hasDuplication = true;
                }
            }
            if (!hasDuplication) {
                return i;
            }
        }
        return -1;
    }
}

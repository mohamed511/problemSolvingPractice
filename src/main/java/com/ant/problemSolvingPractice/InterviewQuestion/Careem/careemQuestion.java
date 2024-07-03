package com.ant.problemSolvingPractice.InterviewQuestion.Careem;

import java.util.HashMap;
import java.util.Map;

public class careemQuestion {
    // given input of 2 string s1 and s2 verify if s2 contains permutation of characters of s1
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "xyzcabtvu";
        System.out.println(checkString(s1, s2));
    }

    public static boolean checkString(String s1, String s2) {
        int len_s1 = s1.length();
        int len_s2 = s2.length();

        if (len_s1 > len_s2) {
            return false;
        }

        Map<Character, Integer> freq_s1 = new HashMap<>();
        Map<Character, Integer> freq_window = new HashMap<>();

        // Build frequency maps for s1 and the window in s2
        for (char c : s1.toCharArray()) {
            freq_s1.put(c, freq_s1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < len_s1; i++) {

            char c = s2.charAt(i);

            freq_window.put(c, freq_window.getOrDefault(c, 0) + 1);

        }


        // Compare initial frequency maps

        if (areMapsEqual(freq_s1, freq_window)) {

            return true;

        }


        // Sliding window approach

        for (int i = len_s1; i < len_s2; i++) {

            char charOut = s2.charAt(i - len_s1);

            if (freq_window.get(charOut) == 1) {

                freq_window.remove(charOut);

            } else {

                freq_window.put(charOut, freq_window.get(charOut) - 1);

            }


            char charIn = s2.charAt(i);

            freq_window.put(charIn, freq_window.getOrDefault(charIn, 0) + 1);


            // Compare frequency maps

            if (areMapsEqual(freq_s1, freq_window)) {

                return true;

            }

        }


        return false;
    }

    private static boolean areMapsEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {

        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value != map2.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;

    }
}

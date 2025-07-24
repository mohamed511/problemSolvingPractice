package com.ant.problemSolvingPractice.InterviewQuestion.Careem;

import java.util.HashMap;
import java.util.Map;

public class careemQuestion {
    // given input of 2 string s1 and s2 verify if s2 contains permutation of characters of s1
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "xyzcabtvu";
        System.out.println(checkInclusionOriginalSolution(s1, s2));

        // my apporach
        String ss1 = "abc";
        String ss2 = "fghbacdfgkkopox";
        System.out.println(checkInclusionOriginalSolution(ss1, ss2));

        String sss1 = "abc";
        String sss2 = "fghdfgkkopobacx";
        System.out.println(checkInclusionOriginalSolution(sss1, sss2));

        String s4= "acb";
        String s5 = "eidbaooo";
        System.out.println(checkInclusionOriginalSolution(s4, s5));

        String s6 = "ab";
        String s7 = "eidbaoaooab";
        System.out.println(checkInclusionOriginalSolution(s6, s7));

    }

    public static boolean checkInclusionOriginalSolution(String s1, String s2) {
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
        if (isEqualChatGpt(freq_s1, freq_window)) {
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
            if (isEqualChatGpt(freq_s1, freq_window)) {
                return true;
            }
        }
        return false;
    }

    /**
     * from chat gpt
     * **/
    private static boolean isEqualChatGpt(Map<Character, Integer> freq1, Map<Character, Integer> window) {
        if (freq1.size() != window.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : freq1.entrySet()) {
            if (!window.containsKey(entry.getKey())) {
                return false;
            }
            if (!window.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }
}

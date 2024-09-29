package com.ant.problemSolvingPractice.algoExpert.String.easy;

import java.util.*;

public class Semordnilap {

    public static void main(String[] args) {
        var input = new String[]{"desserts", "stressed", "hello", "abc", "cba", "abcba"};
        System.out.println(semordnilap(input));
    }

    // O(n*m) time | O(n*m) space - n is the number of word
    // m is the length of the longest word
    // checking if set is contain the word will be O(1)
    public static List<ArrayList<String>> semordnilap(String[] words) {
        Set<String> worrdsSet = new HashSet<>(Arrays.asList(words));
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (String word : words) {
            String revers = new StringBuilder(word).reverse().toString();
            if (worrdsSet.contains(revers) && !revers.equals(word)) {
                ArrayList<String> values = new ArrayList<>();
                values.add(word);
                values.add(revers);
                result.add(values);
                worrdsSet.remove(word);
                worrdsSet.remove(revers);
            }
        }

        return result;
    }
}

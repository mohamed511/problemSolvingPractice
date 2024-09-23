package com.ant.problemSolvingPractice.algoExpert.String.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Semordnilap {

    public static void main(String[] args) {
        var input = new String[]{"desserts", "stressed", "hello","abc","cba"};
        System.out.println(semordnilap(input));
    }

    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {
        Set<String> worrdsSet = new HashSet<>(Arrays.asList(words));
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (String word : words) {
            String revers = new StringBuilder(word).reverse().toString();
            if (worrdsSet.contains(revers) && !worrdsSet.equals(word)) {
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

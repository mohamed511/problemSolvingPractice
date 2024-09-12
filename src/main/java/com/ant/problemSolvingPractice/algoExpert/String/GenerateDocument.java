package com.ant.problemSolvingPractice.algoExpert.String;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {
    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        System.out.println(generateDocument(characters, document));
    }

    public static boolean generateDocument(String characters, String document) {
        Map<Character, Integer> documentFreq = new HashMap<>();
        Map<Character, Integer> charactersFreq = new HashMap<>();
        for (int i = 0; i < document.length(); i++) {
            documentFreq.put(document.charAt(i), documentFreq.getOrDefault(document.charAt(i), 0) + 1);
        }

        for (int i = 0; i < characters.length(); i++) {
            charactersFreq.put(characters.charAt(i), charactersFreq.getOrDefault(characters.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> doc : documentFreq.entrySet()) {
            char key = doc.getKey();
            int value = doc.getValue();
            if (value > charactersFreq.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }

    //O(n+m) time - O(c) space
    // n = number of characters - m = length of document
    // c = number of unique characters
    public static boolean generateDocumentOriginal(String characters, String document) {
        Map<Character, Integer> charactersFreq = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            charactersFreq.put(characters.charAt(i), charactersFreq.getOrDefault(characters.charAt(i), 0) + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            char currentChar = document.charAt(i);
            if (!charactersFreq.containsKey(currentChar) || charactersFreq.get(currentChar) == 0){
                return false;
            }
        }

        return true;
    }
}

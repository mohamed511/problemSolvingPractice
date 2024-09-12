package com.ant.problemSolvingPractice.algoExpert.String.easy;

public class CaesarCypherEncryptor {
    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor1("xyz", 2));
        System.out.println(caesarCypherEncryptor2("xyz", 2));
        System.out.println(caesarCypherEncryptor("xyz", 2));
        System.out.println(solutionAlphabet("xyz", 2));
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print(i + " " + (int) i + " - ");
        }
        System.out.println(caesarCypherEncryptor1("xyz", 54));
        System.out.println(caesarCypherEncryptor2("xyz", 54));
        System.out.println(caesarCypherEncryptor("xyz", 54));
        System.out.println(solutionAlphabet("xyz", 54));
    }

    /**
     * my solution
     * O(n) Time | O(n) space
     ***/
    public static String solutionAlphabet(String str, int key) {
        int newKey = key % 26;
        char[] newStr = new char[str.length()];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str.length(); i++) {
            int newIndex = alphabet.indexOf(str.charAt(i)) + newKey;
            newStr[i] = alphabet.charAt(newIndex % 26);
        }
        return new String(newStr);
    }

    public static String caesarCypherEncryptor1(String str, int key) {
        // Write your code here.
        key = key % 26;
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int unicodeValue = str.charAt(i);
            int nlc = unicodeValue + key;
            if (nlc <= 122) {
                newStr.append((char) nlc);
            } else {
                newStr.append((char) (96 + nlc % 122));
            }

        }
        return new String(newStr);
    }

    /**
     * Algo Solution 1
     * O(n) Time | O(n) space
     ***/
    public static String caesarCypherEncryptor(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = getNewLetter(str.charAt(i), newKey);

        }
        return new String(newLetters);
    }

    public static char getNewLetter(char letter, int key) {
        int newLetterCode = letter + key;
        return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
    }

    /**
     * Algo Solution 2
     * O(n) Time | O(n) space
     ***/
    public static String caesarCypherEncryptor2(String str, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = getNewLetter(str.charAt(i), newKey, alphabet);
        }
        return new String(newLetters);
    }

    public static char getNewLetter(char letter, int key, String alphabet) {
        int newLetterCode = alphabet.indexOf(letter) + key;
        return alphabet.charAt(newLetterCode % 26);
    }
}

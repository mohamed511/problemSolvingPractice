package com.ant.problemSolvingPractice.algoExpert.String.easy;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String str = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println(runLengthEncoding2(str));
    }
// create count field = 1
// loop on the string
// check if the char[i] == char[i-1]
    // if yes count++;
    // else add count and the char to the string builder

    public static String runLengthEncoding(String string) {
        StringBuilder lengthEncoding = new StringBuilder();
        int count = 1;
        if (string.length() == 1) {
            return count + string;
        }
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(i - 1) || count == 9) {
                lengthEncoding.append(count).append(string.charAt(i - 1));
                count = 0;
            }
            count++;
        }
        lengthEncoding.append(count).append(string.charAt(string.length() - 1));
        return lengthEncoding.toString();
    }

    public static String runLengthEncoding2(String string) {
        if (string.length() == 1) {
            return 1 + string;
        }
        StringBuilder lengthEncoding = new StringBuilder();
        int count = 0;
        char current = string.charAt(0);
        for (char c : string.toCharArray()) {
            if (c != current || count == 9) {
                lengthEncoding.append(count).append(current);
                current = c;
                count = 0;
            }
            count++;
        }

        lengthEncoding.append(count).append(string.charAt(string.length() - 1));
        return lengthEncoding.toString();
    }
}

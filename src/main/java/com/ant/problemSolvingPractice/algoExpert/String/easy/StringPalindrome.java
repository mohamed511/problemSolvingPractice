package com.ant.problemSolvingPractice.algoExpert.String.easy;

public class StringPalindrome {
    public static void main(String[] args) {
        String s1 = "abcdcba";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome2(s1));
        System.out.println(isPalindrome3(s1));

    }

    /**
     * O(n) time |
     * O(n^2) space for string as will create new value every tie
     * and O(n) space for string builder
     * add new string contain reverse of the string
     * then compare with it
     * use StringBuilder better that string to avoid
     * o(n^2) space as string will create new string every time
     **/
    public static boolean isPalindrome(String str) {
        //String newStr = "";
        StringBuilder newStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr.append(str.charAt(i));
        }
        System.out.println(newStr);
        return str.contentEquals(newStr);
    }

    /**
     * O(n) time | O(1) space
     **/
    public static boolean isPalindrome2(String str) {
        int right = 0;
        int left = str.length() - 1;
        while (right < left) {
            if (str.charAt(right) != str.charAt(left)) {
                return false;
            }
            right++;
            left--;
        }
        return true;
    }

    //O(n) time | O(n) space
    public static boolean isPalindrome3(String str) {
        return isPalindrome3(str, 0);
    }

    public static boolean isPalindrome3(String str, int right) {
        int left = str.length() - 1 - right;
        return right >= left ? true : str.charAt(right) == str.charAt(left) && isPalindrome3(str, right + 1);
    }
}

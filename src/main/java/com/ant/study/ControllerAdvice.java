package com.ant.study;

public class ControllerAdvice {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s3 = new String("abc");
        System.out.println(s1 == s3);

        System.out.println(s1);
        String s2 = "eidbacoaoo";
        System.out.println(checkInclusion(s1, s2));
        Calculator add = (a, b) -> a + b;
        System.out.println(add.calculate(5, 3)); // Output: 8

    }

    public static boolean checkInclusion(String s1, String s2) {
        return false;
    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

class Count implements Calculator {
    public int calculate(int a, int b) {
        return a + b;
    }
}

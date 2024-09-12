package com.ant.problemSolvingPractice.algoExpert.String.easy;

import java.util.*;

public class CommonCharacters {
    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "cbad"};
        System.out.println(Arrays.toString(commonCharacters(strings)));
        System.out.println(Arrays.toString(commonCharacters2(strings)));
    }

    public static String[] commonCharacters(String[] strings) {
        Map<Character, Integer> countMap = new HashMap<>();
        Set<Character> set;
        for (int i = 0; i < strings.length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < strings[i].length(); j++) {
                set.add(strings[i].charAt(j));
            }

            for (Character c : set) {
                countMap.merge(c, 1, Integer::sum);
            }
        }

        List<String> last = new ArrayList<>();
        for (Map.Entry<Character, Integer> m : countMap.entrySet()) {
            if (m.getValue() == strings.length) {
                last.add(String.valueOf(m.getKey()));
            }
        }
        return last.toArray(new String[0]);
    }


    public static String[] commonCharacters2(String[] strings) {
        String str = getSmallestString(strings);
        Set<Character> potentialString = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            potentialString.add(str.charAt(i));
        }
        for (String s : strings) {
            removeNonExistChar(s, potentialString);
        }

        String[] last = new String[potentialString.size()];
        int i = 0;
        for (Character c : potentialString) {
            last[i] = c.toString();
            i++;
        }
        return last;
    }

    public static String getSmallestString(String[] strings) {
        String smallestString = strings[0];
        for (String str : strings) {
            if (str.length() < smallestString.length()) {
                smallestString = str;
            }
        }
        return smallestString;
    }

    public static void removeNonExistChar(String s, Set<Character> potentialString) {
        Set<Character> sToChar = new HashSet<>();
        Set<Character> toRemove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            sToChar.add(s.charAt(i));
        }

        for (Character c : potentialString) {
            if (!sToChar.contains(c)) {
                toRemove.add(c);
            }
        }

        for (Character c : toRemove) {
            potentialString.remove(c);
        }
    }
}

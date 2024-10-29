package com.ant.problemSolvingPractice.algoExpert.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassPhotos {
    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<>();
        redShirtHeights.add(5);
        redShirtHeights.add(8);
        redShirtHeights.add(1);
        redShirtHeights.add(3);
        redShirtHeights.add(4);
        ArrayList<Integer> blueShirtHeights = new ArrayList<>();
        blueShirtHeights.add(6);
        blueShirtHeights.add(9);
        blueShirtHeights.add(2);
        blueShirtHeights.add(4);
        blueShirtHeights.add(5);
        System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
    }

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        redShirtHeights.sort(Comparator.reverseOrder());
        blueShirtHeights.sort(Comparator.reverseOrder());
        System.out.println(redShirtHeights);
        System.out.println(blueShirtHeights);

        String firstRowShirt = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED" : "BLUR";

        for (int i = 0; i < redShirtHeights.size(); i++) {
            int blueShirt = blueShirtHeights.get(i);
            int redShirt = redShirtHeights.get(i);
            if (firstRowShirt.equalsIgnoreCase("RED")) {
                if (redShirt >= blueShirt) {
                    return false;
                }
            } else {
                if (blueShirt <= redShirt) {
                    return false;
                }
            }

        }

        return true;
    }
}

package com.ant.datastrucutreandalog.metwally.dataStrucutre.array;

import java.util.Arrays;

public class OurArrayTheMain {
    public static void main(String[] args) {
        OurArray<Integer> ourArray = new OurArray<>();
        Integer[] arr = {1, 2, 3};
        System.out.println("before length ==> " + arr.length + " value = " + Arrays.asList(arr));
        arr = ourArray.resize(arr, 6);
        System.out.println("after length ==> " + arr.length + " value = " + Arrays.asList(arr));;
        System.out.println("=========================================================================");
        Integer[] arr2 = {1, 2, 3};
        System.out.println("before length ==> " + arr2.length + " value = " + Arrays.asList(arr2));
        arr2 = ourArray.manualResize(arr2, 6);
        System.out.println("after length ==> " + arr2.length + " value = " + Arrays.asList(arr2));;
    }
}

package com.ant.problemSolvingPractice.algoExpert.array.non_constructible_change;

import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args) {
        //int[] coins = {1,1,2,3,5,7,22};
        int[] coins = {1,1,4};
        System.out.println(nonConstructibleChange(coins));
    }

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChangeCreated = 0;
        for (int coin : coins) {
            if (coin > currentChangeCreated + 1) {
                return currentChangeCreated+1;
            } else {
                currentChangeCreated += coin;
            }
        }
        return currentChangeCreated + 1;
    }
}

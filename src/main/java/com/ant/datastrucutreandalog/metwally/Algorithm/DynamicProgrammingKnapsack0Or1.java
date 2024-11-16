package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgrammingKnapsack0Or1 {
    public static final int MAX_WEIGHT = 8;

    public static void main(String[] args) {
        ItemDynamic item1 = new ItemDynamic("#1", 1, 4);
        ItemDynamic item2 = new ItemDynamic("#2", 3, 9);
        ItemDynamic item3 = new ItemDynamic("#3", 5, 12);
        ItemDynamic item4 = new ItemDynamic("#4", 4, 11);
        List<ItemDynamic> items = new ArrayList<>(List.of(item1, item2, item3, item4));
        knapsack(items,MAX_WEIGHT);
    }

    public static void knapsack(List<ItemDynamic> items,int maxWeight) {
        // Add a dummy item to the beginning of the list to simplify the dynamic
        // programming algorithm
        items.add(0, new ItemDynamic("#0", 0, 0));
        // Initialize the dynamic array
        int[][] dp = new int[items.size()][maxWeight + 1];

        // Compute the maximum profit that can be obtained for each item and weight
        // limit combination
        for (int i = 1; i < items.size(); i++) {
            for (int j = 1; j <= maxWeight; j++) {
                ItemDynamic currentItem = items.get(i);
                int topCell = dp[i - 1][j];
                if (currentItem.getWeight() <= j) {
                    int x = currentItem.getProfit() + dp[i - 1][j - currentItem.getWeight()];
                    dp[i][j] = Math.max(topCell, x);
                } else {
                    dp[i][j] = topCell;
                }

            }
        }
        print(dp);
        System.out.println("==> Max Profit: " + dp[items.size() - 1][maxWeight]);

        // Backtrack through the dynamic programming table to determine the solution
        List<String> solution = new ArrayList<>();
        int i = items.size() - 1;
        int j = maxWeight;
        int remain = maxWeight;
        while (j > 0 && remain >= 0) {
            int currentCell = dp[i][j];
            int topCell = dp[i - 1][j];
            if (currentCell > topCell) {
                // add the item for this value
                solution.add(items.get(i).getName());
                remain = remain - items.get(i).getWeight();
                j = remain;
                i--;
            } else {
                // move to next cell
                i--;
            }
        }

        System.out.println(solution);
    }

    public static void print(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.print(x[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

class ItemDynamic {
    private String name;
    private Integer weight;
    private Integer profit;


    public ItemDynamic(String name, Integer weight, Integer profit) {
        this.name = name;
        this.weight = weight;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" + name + ",v=" + profit + ",w=" + weight + '}';
    }
}

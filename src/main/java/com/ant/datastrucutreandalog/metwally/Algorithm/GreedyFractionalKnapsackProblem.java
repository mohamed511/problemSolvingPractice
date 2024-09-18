package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedyFractionalKnapsackProblem {
    public static void main(String[] args) {
        int[] values = {4, 9, 12, 11, 6, 5};
        int[] weights = {1, 2, 10, 4, 3, 5};
        calculate(values, weights);
    }

    public static void calculate(int[] values, int[] weight) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            Item item = new Item("#" + i, values[i], weight[i]);
            items.add(item);
        }
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
        Knapsack bag = new Knapsack(12);
        int index = 0;
        while (bag.getCurrentCapacity() < bag.getMaxCapacity()) {
            bag.addItem(items.get(index));
            index++;
        }
        System.out.println(bag);
    }

}

class Knapsack {
    private Integer maxCapacity;
    private Integer currentCapacity;
    private Integer totalValue;
    private List<Item> items;

    public Knapsack(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
        this.totalValue = 0;
        this.items = new ArrayList<>();
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(Integer currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Integer getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item newItem) {
        if (newItem.getWeight() > (this.maxCapacity - this.currentCapacity)) {
            // mean we don't have enough capacity for the item and will get a part of the item Weight not all
            int freeCapacity = this.maxCapacity - this.currentCapacity;
            newItem.setWeight(freeCapacity);
            newItem.setValue(newItem.getWeight() * newItem.getRatio());
        }
        // add the item
        this.items.add(newItem);
        // add the new weight on the
        this.currentCapacity += newItem.getWeight();
        this.totalValue += newItem.getValue();
    }

    @Override
    public String toString() {
        return "Knapsack{" +
                "maxCapacity=" + maxCapacity +
                ", currentCapacity=" + currentCapacity +
                ", totalValue=" + totalValue +
                ", items=" + items +
                '}';
    }
}

class Item implements Comparable<Item> {
    private String name;
    private Integer value;
    private Integer weight;
    private Integer ratio;

    public Item(String name, Integer value, Integer weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.ratio = value / weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "{" + name + ",v=" + value + ",w=" + weight +
                ",r=" + ratio +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(o.ratio, this.ratio);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

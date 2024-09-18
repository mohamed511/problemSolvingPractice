package com.ant.datastrucutreandalog.metwally.dataStrucutre.hashTable;

public class MyHashTableMain<TKey, TValue> {
    public static void main(String[] args) throws Exception {
        MyHashTable<String, String> table = new MyHashTable<>();
        table.print();
        table.set("A", "A1");
        table.set("B", "B2");
        table.set("C", "C3");
        table.print();
        //System.out.println("[get] " + table.get("A"));
        System.out.println("[get] " + table.get("C"));
        System.out.println("==================> Start Add new Items");
        table.set("D", "D4");
        table.set("F", "F5");
        table.print();
        System.out.println("[get] " + table.get("C"));
    }
}

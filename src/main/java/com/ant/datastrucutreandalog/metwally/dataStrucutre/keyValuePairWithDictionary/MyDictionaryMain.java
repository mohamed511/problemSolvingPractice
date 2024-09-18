package com.ant.datastrucutreandalog.metwally.dataStrucutre.keyValuePairWithDictionary;

public class MyDictionaryMain {
    public static void main(String[] args) {
        MyDictionary<String, String> dic = new MyDictionary<>();
        dic.print();

        dic.set("Sinar", "sinar@gmail.com");
        dic.set("Elvis", "elvis@gmail.com");
        dic.print();

        dic.set("Tane", "tane@gmail.com");
        dic.set("Gerti", "gerti@gmail.com");
        dic.set("Arist", "arist@gmail.com");

//         dic.set("rArist", "rarist@gmail.com");
//         dic.set("tArist", "tarist@gmail.com");
//         dic.set("yArist", "yarist@gmail.com");

        dic.print();
        System.out.println("==> get data");
        System.out.println(dic.get("Tane"));
        System.out.println(dic.get("Sinar"));
        System.out.println(dic.get("Elviaaa"));

        System.out.println("==> start remove");
        System.out.println(dic.remove("Sinar"));
        System.out.println(dic.remove("Elvis"));
        System.out.println(dic.remove("Tane"));
        System.out.println(dic.remove("Gerti"));
        System.out.println(dic.remove("Arist"));
        System.out.println(dic.remove("hello"));
        dic.print();

        dic.set("Sinar", "sinar@gmail.com");
        dic.print();
        dic.set("Sinar", "updateSinar@gmail.com");
        dic.print();
    }
}

package com.ant.datastrucutreandalog.metwally.Algorithm;

public class IntroCalculateArea {

    public static void main(String[] args) {
        System.out.println(areaOfCircle(10));
        System.out.println(areaOfCircle(20));
        System.out.println();
        System.out.println(areaOfParallelogram(10,20));
        System.out.println(areaOfParallelogram(30,40));
        System.out.println();
        System.out.println(areaOfTrapezoid(10,15,20));
        System.out.println(areaOfTrapezoid(30,35,40));
    }

    public static double areaOfCircle(double radius) {
        return Math.PI * (radius * radius);
    }

    public static double areaOfParallelogram(double base, double height) {
        return base * height;
    }

    public static double areaOfTrapezoid(double baseA, double baseB, double height) {
        return ((baseA+baseB)/2) * height;
    }



}

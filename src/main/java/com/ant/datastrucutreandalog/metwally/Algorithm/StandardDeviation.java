package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.Scanner;

public class StandardDeviation {


    public static void main(String[] args) {
        double sd = 0;
        double ave = 0;
        int n = 0;
        double a = 0;
        double b = 0;
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter array length (n) : ");
        n = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the group of number : ");
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter{ " + i + "}:");
            x[i] = Double.parseDouble(scanner.nextLine());
            ave += x[i];
        }

        ave = ave / n;
        System.out.println(ave);

        for (int i = 0; i < n; i++) {
            a += Math.pow(x[i] - ave, 2);
        }

        b = a / n;
        sd = Math.sqrt(b);
        System.out.println("Standard Deviation = " + sd);
    }
}

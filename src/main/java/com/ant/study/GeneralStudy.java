package com.ant.study;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeneralStudy implements A, B {
    public static void main(String[] args) {

    }

    public void test() {

    }

    public void test(int x) {

    }

    @Override
    public void check() {
        A.super.check();
    }
}

interface A {
    default void check() {
        System.out.println("check");
    }
}

interface B {
    default void check() {
        System.out.println("check");
    }
}
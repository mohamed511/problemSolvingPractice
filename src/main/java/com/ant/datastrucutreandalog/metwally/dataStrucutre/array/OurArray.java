package com.ant.datastrucutreandalog.metwally.dataStrucutre.array;

import java.util.Arrays;

public class OurArray<T> {

    public T[] resize(T[] sourceArray, int size) {
        try {
            // validation
            if (size < 1 || sourceArray == null || size == sourceArray.length) {
                throw new RuntimeException("size may be less than 1 or source = null or size = length");
            } else {
                return Arrays.copyOf(sourceArray, size);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sourceArray;
    }

    public T getValueByIndex(T[] source, int index) {
        if (index < 0) {
            return source[0];
        } else {
            return source[index];
        }
    }

    public Integer[] manualResize(Integer[] sourceArray, int size) {
        try {
            // validation
            if (size < 1 || sourceArray == null || size == sourceArray.length) {
                throw new RuntimeException("size may be less than 1 or source = null or size = length");
            } else {
                Integer[] newArr = new Integer[size];
                for (int i = 0; i < sourceArray.length; i++) {
                    newArr[i] = sourceArray[i];
                }
                return newArr;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}


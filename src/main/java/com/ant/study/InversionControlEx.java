package com.ant.study;

import org.springframework.stereotype.Component;

public class InversionControlEx {
}

@Component
class ComplexAlgo{
    SortAlgo sortAlgo;
    int a;
    ComplexAlgo(SortAlgo sortAlgo){
        this.sortAlgo = sortAlgo;
    }
}
@Component
class QuickSort implements SortAlgo{
    @Override
    public int[] sort(int[] input) {
        return new int[0];
    }
}
interface SortAlgo{
    int[] sort(int[] input);
}


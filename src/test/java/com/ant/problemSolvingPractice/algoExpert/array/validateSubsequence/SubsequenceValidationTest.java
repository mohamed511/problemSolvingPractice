package com.ant.problemSolvingPractice.algoExpert.array.validateSubsequence;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubsequenceValidationTest {
    @Test
    void solution1() {
        var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = Arrays.asList(1, 6, -1, 10);
        boolean result = SubsequenceValidation.solution1(array, sequence);
        assertTrue(result);
    }

    @Test
    void solution2() {
        var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = Arrays.asList(1, 6, -1, 10);
        boolean result = SubsequenceValidation.solution2(array, sequence);
        assertTrue(result);
    }

    @Test
    void solution3() {
        var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = Arrays.asList(1, 6, -1, 10);
        boolean result = SubsequenceValidation.solution3(array, sequence);
        assertTrue(result);
    }
}
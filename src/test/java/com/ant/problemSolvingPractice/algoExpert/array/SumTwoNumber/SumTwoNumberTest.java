package com.ant.problemSolvingPractice.algoExpert.array.SumTwoNumber;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SumTwoNumberTest {

    @Test
    void solution1() {
        int[] result = TwoNumberSum.solution1(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        assertEquals(2, result.length);
        assertThat(result).contains(-1, 11);
    }

    @Test
    void solution2() {
        int[] result = TwoNumberSum.solution2(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        assertEquals(2, result.length);
        assertThat(result).contains(-1, 11);
    }

    @Test
    void solution3() {
        int[] result = TwoNumberSum.solution3(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        assertEquals(2, result.length);
        assertThat(result).contains(-1, 11);
    }
}
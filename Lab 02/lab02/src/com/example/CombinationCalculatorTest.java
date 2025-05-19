package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CombinationCalculatorTest {

    @Test
    public void test_5C2() {
        assertEquals(10, CombinationCalculator.combination(5, 2));
    }

    @Test
    public void test_12C10() {
        assertEquals(66, CombinationCalculator.combination(12, 10));
    }

    @Test
    public void test_6C6() {
        assertEquals(1, CombinationCalculator.combination(6, 6));
    }

    @Test
    public void test_15C2() {
        assertEquals(105, CombinationCalculator.combination(15, 2));
    }

    @Test
    public void test_15C14() {
        assertEquals(15, CombinationCalculator.combination(15, 14));
    }

    @Test
    public void test_3C0() {
        assertEquals(1, CombinationCalculator.combination(3, 0));
    }

    @Test
    public void test_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            CombinationCalculator.combination(-1, 3);
        });
    }

    @Test
    public void test_Long() {
        assertThrows(IllegalArgumentException.class, () -> {
            CombinationCalculator.combination(1000, 3);
        });
    }
}

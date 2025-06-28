package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceDiscountTest {

    OrderService orderService = new OrderService();

    @ParameterizedTest(name = "applyDiscount({0}, {1}) => expected: {2}")
    @CsvSource({
            "100.0, 10.0, 90.0",
            "200.0, 25.0, 150.0",
            "50.0, 5.0, 47.5",
            // Boundary values
            "100.0, 0.0, 100.0",   // No discount
            "100.0, 100.0, 0.0"    // Full discount
    })
    void testApplyDiscount(double total, double discountPercent, double expected) {
        double actual = orderService.applyDiscount(total, discountPercent);
        assertEquals(expected, actual, 0.001);  // delta for floating-point comparison
    }
}

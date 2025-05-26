package org.example;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderServiceTest {

    private static OrderService orderService;
    private static boolean isCartValid;
    private static double totalAmount;

    @BeforeAll
    static void setup() {
        orderService = new OrderService();
        System.out.println("Setup OrderService for testing...");
    }

    @Test
    void test_1_validateCart() {
        List<String> cartItems = Arrays.asList("item1", "item2");
        isCartValid = orderService.validateCart(cartItems);
        System.out.println("test_1_validateCart executed. Cart valid: " + isCartValid);
        Assertions.assertTrue(isCartValid);
    }

    @Test
    void test_2_applyDiscount() {
        if (!isCartValid) {
            Assertions.fail("Cart is invalid. Skipping discount application.");
        }
        double totalBeforeDiscount = 200.0;
        double discountPercent = 10.0;
        totalAmount = orderService.applyDiscount(totalBeforeDiscount, discountPercent);
        System.out.println("test_2_applyDiscount executed. Total after discount: " + totalAmount);
        Assertions.assertEquals(180.0, totalAmount);
    }

    @Test
    void test_3_calculateTotalAfterDiscount() {
        List<Double> itemPrices = Arrays.asList(50.0, 60.0, 70.0); // Total: 180.0
        double calculatedTotal = orderService.calculateTotal(itemPrices);
        System.out.println("test_3_calculateTotalAfterDiscount executed. Calculated Total: " + calculatedTotal);
        Assertions.assertEquals(totalAmount, calculatedTotal);
    }
}

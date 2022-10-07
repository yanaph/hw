package ua.fan.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {
    private final int[][] unordered = {{10, -1, 5}, {6, 9, 4}, {22, 2, 1}};
    private final int[][] ordered = {{10, 9, 8}, {7, 6, 4}, {3, -2, -3}};

    @Test
    void testIsInDescendingOrder() {
        Assertions.assertFalse(Task2.isInDescendingOrder(unordered));
        Assertions.assertTrue(Task2.isInDescendingOrder(ordered));
    }
}

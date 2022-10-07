package ua.fan.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1Test {
    private final int[] target = {5, 5, 5};

    @Test
    void testMean() {
        Assertions.assertEquals(5, Task1.mean(target));
    }

    @Test
    void testGeometricMean() {
        Assertions.assertEquals(5, Task1.geometricMean(target));
    }
}

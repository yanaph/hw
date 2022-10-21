package ua.fan.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1Test {
    private final int[] target = {5, 5, 5};
    private final int[] differentNumbers = {2, 4, 2, 4};

    @Test
    void testMean() {
        Assertions.assertEquals(5, Task1.mean(target));
        Assertions.assertEquals(3, Task1.mean(differentNumbers));
    }

    @Test
    void testGeometricMean() {
        Assertions.assertEquals(5, Task1.geometricMean(target));
        Assertions.assertEquals(2.82843, Task1.geometricMean(differentNumbers));
    }
}

package ua.fan.hw5.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1Test {
    private final int[] targetWhenAllLessThan1000 = {500, 50, 200, 300};
    private final int[] target = {1001, 10, 2, 1200};

    @Test
    void testSumWhereMoreThan1000() {
        Assertions.assertEquals(0, Task1.sumWhereMoreThan1000(targetWhenAllLessThan1000));
        Assertions.assertEquals(2201, Task1.sumWhereMoreThan1000(target));
    }
}

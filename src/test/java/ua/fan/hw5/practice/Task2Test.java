package ua.fan.hw5.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {
    private final int[] allGirls = {150, 160, 190, 140};
    private final int[] girlsAndBoys = {-150, 160, -150, 140};

    @Test
    void testAvgBoysHeight(){
        Assertions.assertEquals(0, Task2.avgBoysHeight(allGirls));
        Assertions.assertEquals(150, Task2.avgBoysHeight(girlsAndBoys));
    }
}

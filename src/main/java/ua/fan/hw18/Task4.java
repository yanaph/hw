package ua.fan.hw18;

import java.util.ArrayList;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(5, -2, 0, -5));
        int min = integers.stream()
                .reduce(0, (a, b) -> (a < b) ? a : b);
        System.out.println("\nInitial: " + integers);
        System.out.printf("Min. element: %d%n", min);
    }
}

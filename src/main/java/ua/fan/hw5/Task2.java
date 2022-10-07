package ua.fan.hw5;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[][] ordered = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] random = new int[3][3];
        fillRandArray(random);
        System.out.println("-----> Array with values in descending order:");
        printArray(ordered);
        System.out.println("---> is in descending order: " + isInDescendingOrder(ordered) + "\n");

        System.out.println("-----> Array with values in random order:");
        printArray(random);
        System.out.println("---> is in descending order: " + isInDescendingOrder(random));
    }

    private static void printArray(int[][] array) {
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void fillRandArray(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
    }

    public static boolean isInDescendingOrder(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i != 0 & j != 0) && array[i][j - 1] < array[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
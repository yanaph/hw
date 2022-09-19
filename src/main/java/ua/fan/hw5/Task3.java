package ua.fan.hw5;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[][] initial = new int[3][3];
        fillRandArray(initial);
        printArray(initial);
        System.out.println();
        printArray(arrayPermutation(initial));
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

    private static int[][] copyArray(int[][] array) {
        int[][] copy = new int[array.length][array[0].length];
        for (int i = 0; i < copy.length; i++) {
            System.arraycopy(array[i], 0, copy[i], 0, copy[i].length);
        }
        return copy;
    }

    private static int[][] arrayPermutation(int[][] array) {
        int[][] copy = copyArray(array);
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (i > j) {
                    int tmp = copy[i][j];
                    copy[i][j] = copy[j][i];
                    copy[j][i] = tmp;
                }
            }
        }
        return copy;
    }
}

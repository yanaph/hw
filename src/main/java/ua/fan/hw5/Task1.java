package ua.fan.hw5;

import java.util.Arrays;

public class Task1 {
        public static void main(String[] args) {
            int[][] numbers = new int[4][3];
            fillArrayWithIndexValues(numbers);
            printArray(numbers);
        }

        private static void printArray(int[][] array) {
            for (int[] ints : array) {
                System.out.println(Arrays.toString(ints));
            }
        }

        private static void fillArrayWithIndexValues(int[][] array) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (i % 2 != 0) {
                        array[i][j] -= i * array[i].length + j + 1;
                    } else {
                        array[i][j] = i * array[i].length + j + 1;
                    }
                }
            }
        }
}

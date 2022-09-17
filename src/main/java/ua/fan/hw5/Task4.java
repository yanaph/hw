package ua.fan.hw5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int[][] initial = new int[3][3];
        fillRandArray(initial);
        printArray(initial);
        System.out.println();
        printArray(deleteElement(initial));
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

    private static int rowBySequenceNumber(int num, int[][] array) {
        if (num % array[0].length == 0) {
            return num / array[0].length - 1;
        }
        return num / array[0].length;
    }

    private static int colBySequenceNumber(int num, int[][] array) {
        if (num % array[0].length == 0) {
            return array[0].length - 1;
        }
        return (num - 1) % array[0].length;
    }

    private static int[][] deleteElement(int[][] array) {
        int[][] copy = copyArray(array);

        System.out.println("Enter a sequence number of the element you want to delete:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int row = rowBySequenceNumber(num, copy);
        int col = colBySequenceNumber(num, copy);

        boolean found = false;
        for (int i = row; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (!found && j == col) {
                    copy[i][j] = 0;
                    found = true;
                } else if (found){
                    int tmp = copy[i][j];
                    if (j != 0) {
                        copy[i][j] = copy[i][j - 1];
                        copy[i][j - 1] = tmp;
                    } else {
                        copy[i][j] = copy[i - 1][copy[i].length - 1];
                        copy[i - 1][copy[i].length - 1] = tmp;
                    }
                }
            }
        }
        return copy;
    }
}
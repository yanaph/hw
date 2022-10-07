package ua.fan.hw5.practice;

//Известен рост каждого из 25 учеников класса. Рост мальчиков условно задан
//отрицательными числами. Определить средний рост мальчиков и средний рост девочек.
//Пример ввода [160, 150, 148, -160, -170]

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] height = new int[25];
        fillArray(height);
        System.out.println("\nInitial array: " + Arrays.toString(height));
        if (avgBoysHeight(height) == 0) {
            System.out.println("There are no boys in class");
        } else {
            System.out.println("Average boys' height is " + avgBoysHeight(height));
        }
    }

    public static double avgBoysHeight(int[] array) {
        double sumHeight = 0, count = 0;
        for (int j : array) {
            if (j < 0) {
                sumHeight += -j;
                count++;
            }
        }
        if (count != 0) {
            return sumHeight / count;
        } else {
            return 0;
        }
    }

    private static void fillArray(int[] array) {
        Random rand = new Random();
        int sign;
        for (int i = 0; i < array.length; i++) {
            sign = rand.nextInt(10) - 4; //[-4;5]
            if (sign < 0) {
                array[i] = -(rand.nextInt(30) + 140); // [-169;-140]
            } else {
                array[i] = rand.nextInt(30) + 140; // [140;169]
            }
        }
    }


}

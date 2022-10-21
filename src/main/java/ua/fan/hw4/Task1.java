package ua.fan.hw4;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[400];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (1 + Math.random() * 10);
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Mean = " + mean(array));
        System.out.println("Geometric mean = " + geometricMean(array));
    }

    static double mean (int[] arr) {
        double sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum/(arr.length);
    }

    static double geometricMean (int[] arr) {
        double product = 1;
        for (int j : arr) {
            product *= j;
        }
        return roundDouble(Math.pow(product, 1D/arr.length));
    }

    static double roundDouble (double value){
        return (double)Math.round(value * 100000d) / 100000d;
    }
}
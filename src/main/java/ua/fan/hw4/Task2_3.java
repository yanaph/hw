package ua.fan.hw4;

import java.util.Arrays;

public class Task2_3 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (1 + Math.random() * 10);
        }
        System.out.println(Arrays.toString(array));
        System.out.println("There are: \n"
                + countPrimeNumbers(array) + " prime and "
                + countCompositeNumbers(array) + " composite numbers.");

    }

    static int countPrimeNumbers(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (isPrimeNum(j)) {
                count++;
            }
        }
        return count;
    }

    static int countCompositeNumbers(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (isCompositeNum(j)) {
                count++;
            }
        }
        return count;
    }

    static boolean isPrimeNum(int number) {
        boolean prime = true;
        if (number != 1) {
            for (int i = 2; i < number; i++) {
                if (i != number && number % i == 0) {
                    prime = false;
                    break;
                }
            }
        } else {
            prime = false;
        }
        return prime;
    }

    static boolean isCompositeNum(int number) {
        boolean composite = false;
        if (number != 1) {
            for (int i = 2; i < number; i++) {
                if (i != number && number % i == 0) {
                    composite = true;
                    break;
                }
            }
        }
        return composite;
    }
}
package ua.fan.hw4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[2000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (1 + Math.random() * 100);
        }
        System.out.println("Original:");
        System.out.println(Arrays.toString(array));
        System.out.println("with annulled evens: ");
        System.out.println(Arrays.toString(nullAllEvens(array)));
    }

    static int[] nullAllEvens(int[] arr) {
        int[] annulled = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < annulled.length; i++) {
            if (annulled[i] % 2 == 0) {
                annulled[i] = 0;
            }
        }
        return annulled;
    }
}
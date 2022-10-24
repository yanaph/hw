package ua.fan.hw5.practice;

//Известны данные о стоимости каждого из 12 товаров. Найти общую стоимость тех товаров,
//которые стоят дороже 1000 uah (количество таких товаров неизвестно).

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] price = new int[12];
        fillRandArray(price);
        System.out.println(Arrays.toString(price));
        System.out.println("sum where price > 1000: " + sumWhereMoreThan1000(price));
    }

    private static void fillRandArray(int[] array) {
        Random random = new Random();
        for (int j = 0; j < array.length; j++) {
            array[j] = random.nextInt(2000);
        }
    }

    public static int sumWhereMoreThan1000(int[] array) {
        int sum = 0;
        for (int j : array) {
            if (j > 1000) {
                sum += j;
            }
        }
        return sum;
    }
}

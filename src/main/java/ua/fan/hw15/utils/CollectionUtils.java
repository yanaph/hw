package ua.fan.hw15.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {
    private static int getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static List<Integer> getOddNumber(List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
        return oddNumbers;
    }

    private static List<String> convertToStringList(List<Integer> numbers) {
        List<String> convertedList = new ArrayList<>();
        for (Integer number : numbers) {
            convertedList.add(number.toString());
        }
        return convertedList;
    }

    private static List<String> doubling(List<String> strings) {
        List<String> doubledList = new ArrayList<>();
        for (String string : strings) {
            doubledList.add(string + string);
        }
        return doubledList;
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(2);
        integerList.add(1);

        System.out.println("---> Initial collection");
        integerList.forEach(number -> System.out.printf(number + " "));

        System.out.println("\n---> Sum of numbers");
        System.out.println(getSum(integerList));

        System.out.println("---> Odd numbers");
        getOddNumber(integerList).forEach(oddNumber -> System.out.printf(oddNumber + " "));

        System.out.println("\n---> Convert to string");
        List<String> strings = convertToStringList(integerList);
        strings.forEach(string -> System.out.printf(string + " "));

        System.out.println("\n---> Doubling strings");
        doubling(strings).forEach(string -> System.out.printf(string + " "));
        System.out.println();
    }
}

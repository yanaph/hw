package ua.fan.hw14;

import java.util.Arrays;

public class PracticeUtil {
    public static <T> void printFormattedOutput(T t) {
        System.out.println("***{" + t + "}***");
    }

    public <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        printFormattedOutput(12);
        printFormattedOutput("hello");

        PracticeUtil practiceUtil = new PracticeUtil();
        Integer[] intArray = {1, 2, 3, 4};
        String[] stringArray = {"hello", "hallo", "hi"};
        practiceUtil.printArray(intArray);
        practiceUtil.printArray(stringArray);
    }
}
package ua.fan.hw18;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        String[] strings = {"alley", "darkness", "border", "currently"};
        Arrays.stream(strings).sorted().forEach(System.out::println);
    }
}

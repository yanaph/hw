package ua.fan.hw16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTiming {
    public static void addMillionElementsToList(List<Integer> list) {
        for (int i = 0; i < 1000000; i++) {
            list.add(5);
        }
    }

    public static void chooseRandomElementMillionTimes(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            System.out.println(list.get(random.nextInt(list.size())));
        }
    }

    public static void printTimingForAdding(List<Integer> list){
        long start = System.currentTimeMillis();
        addMillionElementsToList(list);
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        System.out.println("Adding to list was completed in " + elapsedTimeMillis + "ms");
    }

    public static void printTimingForChoosing(List<Integer> list){
        long start = System.currentTimeMillis();
        chooseRandomElementMillionTimes(list);
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        System.out.println("Choosing from list was completed in " + elapsedTimeMillis + "ms");
    }

    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        System.out.println("===> ArrayList");
        printTimingForAdding(integerArrayList);
        printTimingForChoosing(integerArrayList);
        System.out.println("===> LinkedList");
        printTimingForAdding(integerLinkedList);
        printTimingForChoosing(integerLinkedList);
    }
}

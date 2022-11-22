package ua.fan.hw18;

import ua.fan.hw18.model.Box;
import ua.fan.hw18.model.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Task5 {
    static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            boxes.add(new Box(RANDOM.nextInt(10), RANDOM.nextInt(3)));
        }
        boxes.forEach(System.out::println);
        boxes.stream()
                .filter(box -> box.isSuitable(6))
                .map(Box::getItems)
                .flatMap(Collection::stream)
                .map(Item::getCost)
                .sorted()
                .forEach(price -> System.out.printf("%.2f%n", price));
    }
}

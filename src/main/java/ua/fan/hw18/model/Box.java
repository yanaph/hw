package ua.fan.hw18.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
public class Box {
    int size;
    ArrayList<Item> items;

    public Box(int size, int numberOfItemsInBox) {
        this.size = size;
        items = new ArrayList<>();
        if (numberOfItemsInBox <= size) {
            for (int i = 0; i < numberOfItemsInBox; i++) {
                items.add(new Item());
            }
        } else {
            items.add(new Item());
        }
    }

    public boolean isSuitable(int minSizeLimit) {
        return size >= minSizeLimit;
    }
}

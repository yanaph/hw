package ua.fan.hw18.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Random;
@ToString
@Getter
public class Item {
    static final Random RANDOM = new Random();
    String name;
    double cost;

    public Item() {
        this.name = String.format("Item%d", RANDOM.nextInt(1000));
        this.cost = RANDOM.nextDouble(100);
    }
}

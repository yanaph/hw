package ua.fan.hw32.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
public class Horse {
    private int distance_left;
    private int speed;
    private int horseNumber;

    public Horse(int distance_left, int speed) {
        this.distance_left = distance_left;
        this.speed = speed;
    }
}

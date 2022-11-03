package ua.fan.hw15.model;

import java.util.TreeSet;

public class Box implements Comparable<Box> {
    private final int capacity;

    public Box(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int compareTo(Box o) {
        if (capacity != 0 && o.getCapacity() != 0) {
            return Integer.compare(o.getCapacity(), capacity);
        } else if (capacity == 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        TreeSet<Box> boxes = new TreeSet<>();
        boxes.add(new Box(15));
        boxes.add(new Box(100));
        boxes.add(new Box(0));
        boxes.add(new Box(20));
        boxes.add(new Box(0));
        boxes.forEach(box -> System.out.println(box.getCapacity()));
    }
}

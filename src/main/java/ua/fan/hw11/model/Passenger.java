package ua.fan.hw11.model;

public class Passenger {
    private final String name;
    private final int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + age + "y.o.";
    }
}

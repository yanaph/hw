package ua.fan.hw11.model;

import ua.fan.hw11.interfaces.Recovery;

public class Car implements Recovery {
    protected int series;
    protected int year;
    protected String color;
    protected int currentFuelLevel;
    protected final int FUEL_CONSUMPTION = 10; //in km per liter
    protected final int MAX_FUEL = 100;

    public Car(int series, int year, String color, int currentFuelLevel) {
        this.series = series;
        this.year = year;
        this.color = color;
        this.currentFuelLevel = Math.min(currentFuelLevel, MAX_FUEL);
    }

    public void movement() {
        System.out.println("Let's start the trip!");
        int distance = 0;
        while (currentFuelLevel > 0){
            currentFuelLevel --;
            distance += FUEL_CONSUMPTION;
        }
        System.out.println("The trip is over: no fuel left.");
        System.out.println("Traveled distance: " + distance);
    }

    public void printStatistics() {
        System.out.println(
                "Series: " + series +
                "\nYear: " + year +
                "\nColor: " + color +
                "\nFuel: " + currentFuelLevel +
                "\nFuel consumption: " + FUEL_CONSUMPTION);
    }

    @Override
    public void refuel() {
        currentFuelLevel = MAX_FUEL;
        System.out.println("Car is refueled! \nFuel: " + currentFuelLevel);
    }
}
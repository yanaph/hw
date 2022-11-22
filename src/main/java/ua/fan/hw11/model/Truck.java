package ua.fan.hw11.model;

import ua.fan.hw11.interfaces.Recovery;

public class Truck extends Car implements Recovery {
    private double cargo;

    public Truck(int series, int year, String color, int currentFuelLevel) {
        super(series, year, color, currentFuelLevel);
        this.cargo = 0;
    }

    public void cargoLoadingAndUnloading(double cargo) {
        if (cargo < 0) {
            if (this.cargo < -cargo || this.cargo == 0) {
                System.out.println("Truck is empty! Cargo can not be unloaded.");
            } else {
                this.cargo += cargo;
                System.out.println("Cargo was unloaded! " + this.cargo + " kg of cargo left.");
            }
        } else {
            this.cargo += cargo;
            System.out.println("Cargo was loaded! There are " + this.cargo + " kg of cargo now.");
        }
    }

    @Override
    public void movement() {
        System.out.println("Let's start the trip!");
        int distance = 0;
        while (currentFuelLevel > 0) {
            currentFuelLevel --;
            distance += FUEL_CONSUMPTION/2;
        }
        System.out.println("The trip is over: no fuel left.");
        System.out.println("Traveled distance: " + distance);
    }

    @Override
    public void refuel() {
        System.out.println("Truck is refueled! \nFuel: " + currentFuelLevel);
    }
}
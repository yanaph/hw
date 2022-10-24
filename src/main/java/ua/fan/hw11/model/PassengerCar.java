package ua.fan.hw11.model;

import ua.fan.hw11.interfaces.Recovery;

public class PassengerCar extends Car implements Recovery {
    private final Passenger[] passengers;

    public PassengerCar(int series, int year, String color, int currentFuelLevel) {
        super(series, year, color, currentFuelLevel);
        passengers = new Passenger[3];
    }

    public void addPassenger(Passenger passenger) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                System.out.println("Passenger has been successfully added!");
                return;
            } else if (i == passengers.length - 1){
                System.out.println("There can't be more than 3 passengers!");
            }
        }
    }

    public void printAllPassengers() {
        if (passengers[0] == null) {
            System.out.println("There are no passengers in the car");
        } else {
            for (Passenger passenger : passengers) {
                if (passenger != null) {
                    System.out.println(passenger);
                }
            }
        }
    }
}
package ua.fan.hw11;

import ua.fan.hw11.model.Car;
import ua.fan.hw11.model.Passenger;
import ua.fan.hw11.model.PassengerCar;
import ua.fan.hw11.model.Truck;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------- CAR --------------");
        Car car = new Car(7, 2013, "Blue", 60);
        System.out.println("---> MOVEMENT METHOD:");
        car.movement();
        System.out.println("\n---> STATISTICS METHOD:");
        car.printStatistics();
        System.out.println("\n---> REFUEL METHOD:");
        car.refuel();


        System.out.println("\n-------------- PASSENGER CAR --------------");
        PassengerCar passengerCar = new PassengerCar(9, 2019, "Yellow", 60);
        System.out.println("-----> PRINT ALL PASSENGERS METHOD:");
        passengerCar.printAllPassengers();
        System.out.println("\n-----> ADD PASSENGER METHOD:");
        Passenger passenger1 = new Passenger("Linda", 21);
        Passenger passenger2 = new Passenger("Stacy", 25);
        Passenger passenger3 = new Passenger("Emma", 21);
        Passenger passenger4 = new Passenger("Lucy", 25);
        passengerCar.addPassenger(passenger1);
        passengerCar.addPassenger(passenger2);
        passengerCar.addPassenger(passenger3);
        passengerCar.addPassenger(passenger4);
        System.out.println("\n---> PRINT ALL PASSENGERS METHOD:");
        passengerCar.printAllPassengers();
        System.out.println("\n---> MOVEMENT METHOD:");
        passengerCar.movement();
        System.out.println("\n---> REFUEL METHOD:");
        passengerCar.refuel();


        System.out.println("\n-------------- TRUCK --------------");
        Truck truck = new Truck(6, 2003, "Yellow", 60);
        System.out.println("---> CARGO LOADING/UNLOADING METHOD:");
        System.out.println("-> cargo = -5000 (kg)");
        truck.cargoLoadingAndUnloading(-5000);
        System.out.println("-> cargo = 5000 (kg)");
        truck.cargoLoadingAndUnloading(5000);
        System.out.println("-> cargo = -2000 (kg)");
        truck.cargoLoadingAndUnloading(-2000);
        System.out.println("\n---> MOVEMENT METHOD:");
        truck.movement();
        System.out.println("\n---> REFUEL METHOD:");
        truck.refuel();
    }

}

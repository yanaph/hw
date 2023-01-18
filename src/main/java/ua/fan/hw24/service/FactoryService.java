package ua.fan.hw24.service;

import ua.fan.hw24.entity.Factory;


import java.util.Random;

public class FactoryService {
    private final static Random RANDOM = new Random();
    public Factory createFactory(String name) {
        return new Factory(name, "Country-"+RANDOM.nextInt(500));
    }
}
